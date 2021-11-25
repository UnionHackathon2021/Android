package kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity

data class StoreSummery(
    val name: String,
    val percent: Int,
    val deliveryPrice: Int,
    val minOrderAmountPrice: Int,
    val image: String
)