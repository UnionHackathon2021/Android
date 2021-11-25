package kr.hs.dgsw.unionhackathon.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity.StoreSummery

class FoodCafeViewModel: ViewModel() {
    val nearStoreList = MutableLiveData<List<StoreSummery>>()
    val storeList = MutableLiveData<List<StoreSummery>>()

    fun getStoreList() {
        nearStoreList.value = arrayListOf(
            StoreSummery("달콤", 10, 10000, 2000,
                "http://kormedi.com/wp-content/uploads/2021/05/0002313329_001_202105200942055171-580x387.jpg")
        )
    }

}