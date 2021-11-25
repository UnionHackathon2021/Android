package kr.hs.dgsw.unionhackathon.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity.StoreSummery

class FoodPizzaViewModel: ViewModel() {
    val nearStoreList = MutableLiveData<List<StoreSummery>>()
    val storeList = MutableLiveData<List<StoreSummery>>()

    fun getStoreList() {
        nearStoreList.value = arrayListOf(
            StoreSummery("야미피자", 10, 10000, 2000,
                "https://mblogthumb-phinf.pstatic.net/MjAyMTA4MjZfMjM0/MDAxNjI5OTcyMjY2MzA0._8b0RDc0b2WS_PBCkm6PUaOMk2QlPzlP_50wTHhVvfIg.j3Eu6nogwVhYCnb41xJPM5sXKMlpIBW_J0jBlr3D3tIg.JPEG.totos1207/%EB%83%89%EB%8F%99%ED%94%BC%EC%9E%90_(14).jpg?type=w800")
        )
        storeList.value = arrayListOf(
            StoreSummery("응피자", 10, 10000, 2000,
            "https://w.namu.la/s/8c2aebf04d4c6e0ae24ebf3b3789cb064f353da40f0a2916630ee33cc34742414ac8427b8765569e84d615a24cac7bc389ada2e5c60579541ea8b41be9b22db6d0ce58f59fd1ac01912436c928605cd86974e360258a66ac0374662e70b0ae73"),
            StoreSummery("피자에 하늘", 15, 10000, 2000,
            "http://pizzaetang01.cafe24.com/mobile/img/sub/brand_pizza01.jpg")
        )
    }

}