package kr.hs.dgsw.unionhackathon.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity.StoreSummery

class FoodChineseViewModel: ViewModel() {
    val nearStoreList = MutableLiveData<List<StoreSummery>>()
    val storeList = MutableLiveData<List<StoreSummery>>()

    fun getStoreList() {
        nearStoreList.value = arrayListOf(
            StoreSummery("베이징", 10, 10000, 2000,
                "https://cloudfront-ap-northeast-1.images.arcpublishing.com/chosun/UZLLMAMPOGGGWJP4FKEA4MQAOQ.jpg")
        )
        storeList.value = arrayListOf(
            StoreSummery("구지반점", 40, 10000, 2000,
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQi3pvKjyoNPx_KWMEBgMjmEb9NrJJe-LY_lg&usqp=CAU"),
            StoreSummery("빨반점", 70, 10000, 2000,
            "https://upload.wikimedia.org/wikipedia/commons/e/e9/Korean.cuisine-Jajangmyeon-01.jpg")
        )
    }

}