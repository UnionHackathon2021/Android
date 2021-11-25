package kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity

data class ReviewList(
    val reviewResponseList: List<Review>?,
    val totalNegative: Int,
    val totalNeutral: Int,
    val totalPositive: Int
)
