package kr.hs.dgsw.unionhackathon.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity.StoreSummery

class FoodSnackBarViewModel: ViewModel() {
    val nearStoreList = MutableLiveData<List<StoreSummery>>()
    val storeList = MutableLiveData<List<StoreSummery>>()

    fun getStoreList() {
        nearStoreList.value = arrayListOf(
            StoreSummery("떡볶끼이이익", 10, 10000, 2000,
                "https://lh3.googleusercontent.com/proxy/REklpyoI5R4WADT1LdL6vL33TZkvoieN6KiSVbZ4pi7DwgGYiDH8JVdzeqjP4uOBU2sEhat7pqTbb4GZGCY5YBoaBEUfb9E08ktyNiiMzOvFO_zwA4cFiQ0")
        )
        storeList.value = arrayListOf(
            StoreSummery("인간이 만드는 떡볶이", 30, 10000, 2000,
            "https://img-cf.kurly.com/shop/data/goodsview/20181119/gv30000036376_1.jpg"),
            StoreSummery("떡볶이 맵습니다", 100, 10000, 2000,
            "https://cdn.meesig.com/v3/prod/image/item/mainpage/907/ad4474bef39c4167b84477eaa7a5052f20210708171733.")
        )
    }

}