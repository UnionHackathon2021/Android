package kr.hs.dgsw.unionhackathon.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity.StoreSummery

class FoodJapaneseViewModel: ViewModel() {
    val nearStoreList = MutableLiveData<List<StoreSummery>>()
    val storeList = MutableLiveData<List<StoreSummery>>()

    fun getStoreList() {
        nearStoreList.value = arrayListOf(
            StoreSummery("진짜라멘", 10, 10000, 2000,
                "https://upload.wikimedia.org/wikipedia/commons/a/a9/%EB%8F%88%EC%BD%94%EC%B8%A0%EB%9D%BC%EB%A9%98.jpg")
        )
        storeList.value = arrayListOf(
            StoreSummery("초밥집", 80, 10000, 2000,
            "https://img.insight.co.kr/static/2019/02/20/700/my98rquw0o0652018tdo.jpg"),
            StoreSummery("돈코츠라멘", 30, 10000, 2000,
            "https://t1.daumcdn.net/thumb/R720x0/?fname=http://t1.daumcdn.net/brunch/service/user/7CS/image/NQdxY_VJMc25GPK9nR57huPRQHI")
        )
    }

}