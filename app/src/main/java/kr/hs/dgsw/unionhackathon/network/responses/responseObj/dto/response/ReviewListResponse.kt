package kr.hs.dgsw.unionhackathon.network.responses.responseObj.dto.response

data class ReviewListResponse(
    val reviewResponseList: List<ReviewResponse>,
    val totalNegative: Int,
    val totalNeutral: Int,
    val totalPositive: Int
)
