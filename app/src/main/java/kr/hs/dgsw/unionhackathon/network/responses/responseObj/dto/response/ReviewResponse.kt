package kr.hs.dgsw.unionhackathon.network.responses.responseObj.dto.response

data class ReviewResponse(
    val id: Int,
    val content: String,
    val sentiment: String,
    val positive: Float,
    val negative: Float,
    val neutral: Float
)
