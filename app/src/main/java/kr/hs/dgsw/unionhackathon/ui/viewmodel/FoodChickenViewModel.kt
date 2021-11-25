package kr.hs.dgsw.unionhackathon.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity.StoreSummery

class FoodChickenViewModel: ViewModel() {
    val nearStoreList = MutableLiveData<List<StoreSummery>>()
    val storeList = MutableLiveData<List<StoreSummery>>()

    fun getStoreList() {
        nearStoreList.value = arrayListOf(
            StoreSummery("치킨나라 피자공주", 10, 10000, 2000,
                "http://pncg.co.kr/upload/board/1562915241.jpg")
        )
        storeList.value = arrayListOf(
            StoreSummery("처GOD집", 10, 10000, 2000,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT46jDwoOOLY_lFgkVCu5vJRs9fR_vyqLszVVJQ1YCdhxmgab7VEHWWQAmb7CucxLANqIc&usqp=CAU"),
            StoreSummery("치킨 장사 합니다", 10, 10000, 2000,
            "https://kfcapi.inicis.com/kfcs_api_img/KFCS/goods/DL_2174430_20211020170748938.png"),
            StoreSummery("너무 비싸요 치킨", 10, 10000, 2000,
            "https://pds.joongang.co.kr/news/component/htmlphoto_mmdata/201903/08/52cf07ea-c8da-4574-b0e9-21e0e3b31118.jpg")
        )
    }

}