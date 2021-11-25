package kr.hs.dgsw.unionhackathon.network.service

import io.reactivex.Single
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.dto.request.ReviewRequest
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.dto.response.ReviewList
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ReviewService {
    @GET("/review")
    fun getReviews(): Single<Response<ReviewList>>

    @POST("/review")
    fun postCreateReview(@Body reviewRequest: ReviewRequest): Single<Response<String>>
}