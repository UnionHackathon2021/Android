package kr.hs.dgsw.unionhackathon.network.repository

import android.util.Log
import io.reactivex.Single
import kr.hs.dgsw.unionhackathon.network.responses.response.GetResponses
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.dto.request.ReviewRequest
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.dto.response.ReviewListResponse
import kr.hs.dgsw.unionhackathon.network.service.ReviewService

class ReviewRepository(override val service: ReviewService) : GetResponses<ReviewService>() {

    fun getReviews(): Single<ReviewListResponse> {
        return service.getReviews().map(getResponse())
    }

    fun postCreateReview(reviewRequest: ReviewRequest): Single<Unit> {
        return service.postCreateReview(reviewRequest).map(getResponse())
    }
}