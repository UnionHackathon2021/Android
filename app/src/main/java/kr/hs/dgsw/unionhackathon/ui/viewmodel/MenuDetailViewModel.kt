package kr.hs.dgsw.unionhackathon.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.hs.dgsw.unionhackathon.ui.util.SingleLiveEvent

class MenuDetailViewModel: ViewModel() {
    val number = MutableLiveData(1)
    val priceEvent = SingleLiveEvent<Unit>()
}
