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
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.dto.request.VoiceRequest
import okhttp3.ResponseBody
import javax.inject.Inject

@HiltViewModel
class CreateReviewViewModel @Inject constructor(
    private val clovaRepository: ClovaRepository
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val _isSuccess = MutableLiveData<ResponseBody>()
    val isSuccess: LiveData<ResponseBody> = _isSuccess

    private val _isFailure = MutableLiveData<String>()
    val isFailure: LiveData<String> = _isFailure

    val content = MutableLiveData<String>()

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