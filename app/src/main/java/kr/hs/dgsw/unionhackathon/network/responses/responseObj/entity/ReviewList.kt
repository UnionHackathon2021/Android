package kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity

data class ReviewList(
    val totalNegative: Float,
    val totalNeutral: Float,
    val totalPositive: Float,
    val reviewList: List<Review>?
)
