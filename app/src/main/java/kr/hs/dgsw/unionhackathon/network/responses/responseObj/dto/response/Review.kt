package kr.hs.dgsw.unionhackathon.network.responses.responseObj.dto.response

data class Review(
    val content: String,
    val id: Int,
    val negative: Int,
    val neutral: Int,
    val positive: Int,
    val sentiment: String
)