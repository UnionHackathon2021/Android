package kr.hs.dgsw.unionhackathon.network.responses.responseObj.dto.response

data class ReviewListResponse(
    val totalNegative: Float,
    val totalNeutral: Float,
    val totalPositive: Float,
    val reviewList: List<ReviewResponse>
)
