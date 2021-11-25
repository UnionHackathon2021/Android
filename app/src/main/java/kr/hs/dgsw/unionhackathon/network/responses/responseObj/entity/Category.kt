package kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity

data class Category(
    val title: String,
    val detail: String,
    val menuList: List<Menu>,
    val isHeader: Boolean = false
)