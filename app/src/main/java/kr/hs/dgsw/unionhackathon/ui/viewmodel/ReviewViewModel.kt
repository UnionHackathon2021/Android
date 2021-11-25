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
import kr.hs.dgsw.unionhackathon.network.responses.mapper.toEntity
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.dto.request.VoiceRequest
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity.ReviewList
import okhttp3.ResponseBody
import javax.inject.Inject

@HiltViewModel
class ReviewViewModel @Inject constructor(
    private val reviewRepository: ReviewRepository
) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    private val _isSuccess = MutableLiveData<ReviewList>()
    val isSuccess: LiveData<ReviewList> = _isSuccess

    private val _isFailure = MutableLiveData<String>()
    val isFailure: LiveData<String> = _isFailure

    fun getReviews() {
        compositeDisposable.add(
            reviewRepository.getReviews()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    Log.d("getReview", it.toString())
                    _isSuccess.postValue(it.toEntity())
                }, {
                    Log.e("getReviews", it.message.toString())
                    _isFailure.postValue(it.message)
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}