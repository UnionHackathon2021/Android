package kr.hs.dgsw.unionhackathon.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity.Category
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity.Menu
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity.Store

class StoreInfoViewModel: ViewModel() {
    val store = MutableLiveData<Store>()

    fun postLike(isEnabled: Boolean) {
        store.value?.likeSize?.let {
            store.value?.likeSize = if (!isEnabled) {
                it - 1
            } else {
                it + 1
            }
        }
        store.postValue(store.value)
    }

    fun getStoreInfo() {
        val milkList = listOf(
            Menu("초코우유", "달달한 쪼꼬우유", 10000),
            Menu("딸기우유", "달달한 딸기우유", 10000),
            Menu("바나나우유", "달달한 바나나우유", 10000),
            Menu("그냥우유", "그냥우유", 1000),
        )

        val latteList = listOf(
            Menu("초코라떼", "달달한 쪼꼬라떼", 10000),
            Menu("딸기라떼", "달달한 딸기라떼", 10000),
            Menu("바나나라떼", "달달한 바나나라떼", 10000),
            Menu("라떼는 말이야", "음,,,아무튼,,나때는,,", 0),
        )

        val categoryList = listOf(
            Category(
                "달콤 우유",
                "달달한게 좋제?",
                    milkList
            ),

            Category(
                "달콤 라떼",
                "라떼도 좋잖아?",
                latteList
            ),

            Category(
                "달콤 우유",
                "달달한게 좋제?",
                milkList
            ),

            Category(
                "달콤 라떼",
                "라떼도 좋잖아?",
                latteList
            )
        )

        val famousMenuList = listOf(
            Menu("라떼는 말이야", "음,,,아무튼,,라떼는,,말이,,있었어", 0),
            Menu("초코우유", "달달한 쪼꼬우유", 10000),
            Menu("딸기라떼", "달달한 딸기라떼", 10000),
            Menu("그냥우유", "그냥우유", 1000),
        )

        store.value = Store(
            "달콤",
            15,
            1,
            "현장결제 (카드/현금)",
            2000,
            10000,
            23,
            30,
            categoryList,
            famousMenuList,
            "http://kormedi.com/wp-content/uploads/2021/05/0002313329_001_202105200942055171-580x387.jpg"
        )
    }
}