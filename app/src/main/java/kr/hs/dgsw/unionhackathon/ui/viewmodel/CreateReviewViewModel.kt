package kr.hs.dgsw.unionhackathon.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kr.hs.dgsw.unionhackathon.network.repository.ClovaRepository
import kr.hs.dgsw.unionhackathon.network.repository.ReviewRepository
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.dto.request.ReviewRequest
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.dto.request.VoiceRequest
import okhttp3.ResponseBody
import javax.inject.Inject

@HiltViewModel
class CreateReviewViewModel @Inject constructor(
    private val reviewRepository: ReviewRepository,
    private val clovaRepository: ClovaRepository
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val compositeDisposableCrate = CompositeDisposable()

    private val _isSuccess = MutableLiveData<ResponseBody>()
    val isSuccess: LiveData<ResponseBody> = _isSuccess

    private val _isSuccessCreate = MutableLiveData<String>()
    val isSuccessCreate: LiveData<String> = _isSuccessCreate

    private val _isFailure = MutableLiveData<String>()
    val isFailure: LiveData<String> = _isFailure

    val content = MutableLiveData<String>()

    fun postCreateReview(content: String) {
        val reviewRequest = ReviewRequest(content)

        compositeDisposableCrate.add(
            reviewRepository.postCreateReview(reviewRequest)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    Log.d("postCreateReview", "success")
                    _isSuccessCreate.postValue("success")
                }, {
                    Log.e("postCreateReview", "error: ${it.message}")
                    _isFailure.postValue(it.message)
                })
        )
    }

    fun postVoice() {
        val voiceRequest = VoiceRequest("nhajun", "안녕하세요")

        compositeDisposable.add(
            clovaRepository.postVoice(voiceRequest)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    Log.e("postVoice", it.string())
                    Log.e("postVoice", it.toString())
                    _isSuccess.postValue(it)
                }, {
                    Log.e("postVoice", "error: ${it.message.toString()}")
                    _isFailure.postValue(it.message)
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}