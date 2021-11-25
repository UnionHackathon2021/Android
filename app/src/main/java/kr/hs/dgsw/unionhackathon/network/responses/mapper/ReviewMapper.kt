package kr.hs.dgsw.unionhackathon.network.responses.mapper

import kr.hs.dgsw.unionhackathon.network.responses.responseObj.dto.response.ReviewListResponse
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.dto.response.ReviewResponse
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity.Review
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity.ReviewList

fun ReviewResponse.toEntity(): Review =
    Review(
        this.content,
        this.id,
        this.negative,
        this.neutral,
        this.positive,
        this.sentiment,
        null,
        null
    )

fun ReviewListResponse.toEntity(): ReviewList {
    return if (reviewResponseList == null) {
        ReviewList(
            listOf(),
            this.totalNegative,
            this.totalNeutral,
            this.totalPositive
        )
    } else {
        ReviewList(
            this.reviewResponseList.map { it.toEntity() },
            this.totalNegative,
            this.totalNeutral,
            this.totalPositive
        )
    }

}
