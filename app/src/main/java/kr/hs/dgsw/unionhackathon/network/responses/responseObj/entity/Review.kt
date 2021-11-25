package kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity

data class Review(
    val nickname: String,
    val positive: Int,
    val neutrality: Int,
    val negative: Int,
    val most: String,
    val content: String,
    val menu: List<String>
)
