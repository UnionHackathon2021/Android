package kr.hs.dgsw.unionhackathon.network.responses.mapper

import kr.hs.dgsw.unionhackathon.network.responses.responseObj.dto.response.ReviewListResponse
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.dto.response.ReviewResponse
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity.Review
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity.ReviewList

fun ReviewResponse.toEntity(): Review =
    Review(
        this.id,
        this.content,
        this.sentiment,
        this.positive,
        this.negative,
        this.neutral,
        "닉네임",
        listOf("맛있는 메뉴")
    )

fun ReviewListResponse.toEntity(): ReviewList {
    return if (reviewList == null) {
        ReviewList(
            this.totalNegative,
            this.totalNeutral,
            this.totalPositive,
            listOf()
        )
    } else {
        ReviewList(
            this.totalNegative,
            this.totalNeutral,
            this.totalPositive,
            this.reviewList.map { it.toEntity() }
        )
    }

}
