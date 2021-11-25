package kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity

data class Store(
    val name: String,
    var likeSize: Int,
    val reviewSize: Int,
    val paymentMethod: String,
    val deliveryPrice: Int,
    val minOrderAmountPrice: Int,
    val minDeliveryTime: Int,
    val maxDeliveryTime: Int,
    val categoryList: List<Category>,
    val famousMenuList: List<Menu>,
    val image: String,
)