package kr.hs.dgsw.unionhackathon.network.responses.responseObj.dto.response

data class ReviewList(
    val reviewList: List<Review>,
    val totalNegative: Int,
    val totalNeutral: Int,
    val totalPositive: Int
)
