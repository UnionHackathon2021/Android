package kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity

data class Review(
    val id: Int,
    val content: String,
    val sentiment: String,
    val negative: Float,
    val neutral: Float,
    val positive: Float,

    val nickname: String?,
    val menu: List<String>?
)
