package kr.hs.dgsw.unionhackathon.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity.StoreSummery

class FoodKoreanViewModel: ViewModel() {
    val nearStoreList = MutableLiveData<List<StoreSummery>>()
    val storeList = MutableLiveData<List<StoreSummery>>()

    fun getStoreList() {
        nearStoreList.value = arrayListOf(
            StoreSummery("한식뷔페", 10, 10000, 2000,
                "https://post-phinf.pstatic.net/MjAxOTA1MTVfMTEz/MDAxNTU3ODk5Mzg4NzMx.mwaI-SE-_2qzqOLC7x8qZHsPGQu3bMuF6faqAe-7h08g.PXZIyiNYV69Vpn5GzXb_SchhLn7P-OIG5pNrTwpoTE4g.JPEG/IZarAZYKIIXhOzxVzN6g-V-aNnH4.jpg?type=w400")
        )
        storeList.value = arrayListOf(
            StoreSummery("밥집", 100, 10000, 2000,
                "https://img.huffingtonpost.com/asset/5f6d43e1240000ee1e922da7.jpeg"),
            StoreSummery("한국인의 식사", 60, 10000, 2000,
            "https://w.namu.la/s/ef932b2d7b1bf5ad1f21e4c2d81f5c9238025dd1d9646dea168ca4e3270f5fa5603666ee36e9672844ed46c89642ae5cd4e1e66665def5eb166a0016431df9a9580e3d19dda726a72184c5c2bf83ea15e70aaf9feda20dcd7810b5a0ae218a59")
        )
    }

}