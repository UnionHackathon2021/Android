package kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity

data class Order(
    val title: String,
    val totalPrice: Int,
    val detail: String,
    val number: Int
)