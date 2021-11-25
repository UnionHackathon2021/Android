package kr.hs.dgsw.unionhackathon.network.repository

import io.reactivex.Single
import kr.hs.dgsw.unionhackathon.network.responses.response.GetResponses
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.dto.request.ReviewRequest
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.dto.response.ReviewListResponse
import kr.hs.dgsw.unionhackathon.network.service.ReviewService

class ReviewRepository(override val service: ReviewService) : GetResponses<ReviewService>() {

    fun getReviews(): Single<ReviewListResponse> {
        return service.getReviews().map(getResponse())
    }

    fun postCreateReview(reviewRequest: ReviewRequest): Single<String> {
        return service.postCreateReview(reviewRequest).map(getMessage())
    }
}