package kr.hs.dgsw.unionhackathon.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity.StoreSummery

class FoodNightSnackViewModel: ViewModel() {
    val nearStoreList = MutableLiveData<List<StoreSummery>>()
    val storeList = MutableLiveData<List<StoreSummery>>()

    fun getStoreList() {
        nearStoreList.value = arrayListOf(
            StoreSummery("황족발", 10, 10000, 2000,
                "http://foodyap.co.kr/shopimages/goldplate1/030001000014.jpg?1560851911")
        )
        storeList.value = arrayListOf(
            StoreSummery("밤반찬", 100, 10000, 2000,
            "https://mblogthumb-phinf.pstatic.net/MjAxNzA4MjJfMTYz/MDAxNTAzMzg3NjQ3NTY4.vTc508GAz3f8ZGbL_BkMLwVEqUXpUrw9hJ6S4ZEzox8g.mu9hqXXjG-YcCiZAoYae9SM0RhsMeb9CeehqsXRWxpEg.JPEG.witchyoli/%EC%95%BC%EC%8B%9D_%EB%B2%A0%EC%8A%A4%ED%8A%B810.jpg?type=w800"),
            StoreSummery("니족발", 50, 10000, 2000,
            "https://static.hubzum.zumst.com/hubzum/2019/07/26/11/8291a05e16b14e9b91eedc7a4375c934_780x585.jpg")
        )
    }

}