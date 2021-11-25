package kr.hs.dgsw.unionhackathon.ui.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity.*

class StoreInfoViewModel: ViewModel() {
    val price = ObservableField(0)
    val size = MutableLiveData(0)
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

    fun addOrder(order: Order) {
        price.set((price.get() ?: 0) + order.totalPrice)
        size.value = ((size.value ?: 0) + order.number)
    }

    fun getStoreInfo() {
        val milkList = listOf(
            Menu(
                "초코우유",
                "달달한 쪼꼬우유",
                10000,
                "http://res.heraldm.com/content/image/2015/04/23/20150423000353_0.jpg",
                listOf(
                    Option(
                        "추가 선택",
                        listOf(
                            Check("샷추가", false, 0)
                        ), isCheckBox = true
                    ),

                    Option(
                        "사이즈",
                        listOf(
                            Check("작은거", true, 0),
                            Check("큰거", false, 1000)
                        ), isCheckBox = false
                    )
                )
            ),
            Menu(
                "딸기우유",
                "달달한 딸기우유",
                10000,
                "https://i.ytimg.com/vi/BFjXlR4CXTE/maxresdefault.jpg",
                listOf(
                    Option(
                        "추가 선택",
                        listOf(
                            Check("샷추가", false, 0)
                        ), isCheckBox = true
                    ),

                    Option(
                        "사이즈",
                        listOf(
                            Check("작은거", true, 0),
                            Check("큰거", false, 1000)
                        ), isCheckBox = false
                    )
                )
            ),
            Menu(
                "바나나우유",
                "달달한 바나나우유",
                10000,
                "https://img-s-msn-com.akamaized.net/tenant/amp/entityid/AAP1vOU.img?h=0&w=600&m=6&q=60&u=t&o=f&l=f",
                listOf(
                    Option(
                        "추가 선택",
                        listOf(
                            Check("샷추가", false, 0)
                        ), isCheckBox = true
                    ),

                    Option(
                        "사이즈",
                        listOf(
                            Check("작은거", true, 0),
                            Check("큰거", false, 1000)
                        ), isCheckBox = false
                    )
                )),
            Menu(
                "그냥우유",
                "그냥우유",
                1000,
                "http://kormedi.com/wp-content/uploads/2020/02/gettyimages-973261478-580x580.jpg",
                listOf(
                    Option(
                        "추가 선택",
                        listOf(
                            Check("샷추가", false, 0)
                        ), isCheckBox = true
                    ),

                    Option(
                        "사이즈",
                        listOf(
                            Check("작은거", true, 0),
                            Check("큰거", false, 1000)
                        ), isCheckBox = false
                    )
                )
            ),
        )

        val latteList = listOf(
            Menu(
                "초코라떼",
                "달달한 쪼꼬라떼",
                10000,
                "https://cdn.imweb.me/upload/S20200910a66a52cc7ee04/f60733df7b5ae.jpg",
                listOf(
                    Option(
                        "추가 선택",
                        listOf(
                            Check("샷추가", false, 0)
                        ), isCheckBox = true
                    ),

                    Option(
                        "사이즈",
                        listOf(
                            Check("작은거", true, 0),
                            Check("큰거", false, 1000)
                        ), isCheckBox = false
                    )
                )
            ),
            Menu(
                "딸기라떼",
                "달달한 딸기라떼",
                10000,
                "https://mblogthumb-phinf.pstatic.net/MjAxOTAzMjlfMjkz/MDAxNTUzODcwNjczMjIx.OC-toAn4Z3ycmhnHUoq9NpFlv3nkJazS8jflE7MP2-cg.ZPH_m-9AMDZ1lZStUW0FzkgvyV0ubY-0LfWOZ_57ercg.JPEG.naya399/%EB%94%B8%EA%B8%B0_%EB%9D%BC%EB%96%BC_%EB%A7%8C%EB%93%A4%EA%B8%B0_(1).jpg?type=w800",
                listOf(
                    Option(
                        "추가 선택",
                        listOf(
                            Check("샷추가", false, 0)
                        ), isCheckBox = true
                    ),

                    Option(
                        "사이즈",
                        listOf(
                            Check("작은거", true, 0),
                            Check("큰거", false, 1000)
                        ), isCheckBox = false
                    )
                )
            ),
            Menu(
                "바나나라떼",
                "달달한 바나나라떼",
                10000,
                "https://image.aladin.co.kr/product/21221/80/cover500/p662831422_1.jpg",
                listOf(
                    Option(
                        "추가 선택",
                        listOf(
                            Check("샷추가", false, 0)
                        ), isCheckBox = true
                    ),

                    Option(
                        "사이즈",
                        listOf(
                            Check("작은거", true, 0),
                            Check("큰거", false, 1000)
                        ), isCheckBox = false
                    )
                )
            ),
            Menu(
                "라떼는 말이야",
                "음,,,아무튼,,나때는,,",
                0,
                "https://mblogthumb-phinf.pstatic.net/MjAxOTEyMjdfMzAw/MDAxNTc3NDI0MDg2MzY4.Wgijw2pa3zhUldQk9qutB0qMugXlyWb2LPoxaAvFBUIg.7nSaROiCGeC19gt9rc5g5vxpQu3cf4xUpbnRCY0ilIcg.JPEG.vipgarden/1577424085453.jpg?type=w800",
                listOf(
                    Option(
                        "추가 선택",
                        listOf(
                            Check("라떼의 호통 추가", false, 0)
                        ), isCheckBox = true
                    ),

                    Option(
                        "사이즈",
                        listOf(
                            Check("작은 소리", true, 0),
                            Check("큰 소리", false, 1000)
                        ), isCheckBox = false
                    )
                )
            ),
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
        )

        val famousMenuList = listOf(
            Menu(
                "초코우유",
                "달달한 쪼꼬우유",
                10000,
                "http://res.heraldm.com/content/image/2015/04/23/20150423000353_0.jpg",
                listOf(
                    Option(
                        "추가 선택",
                        listOf(
                            Check("샷추가", false, 0)
                        ), isCheckBox = true
                    ),

                    Option(
                        "사이즈",
                        listOf(
                            Check("작은거", true, 0),
                            Check("큰거", false, 1000)
                        ), isCheckBox = false
                    )
                )
            ),
            Menu(
                "딸기라떼",
                "달달한 딸기라떼",
                10000,
                "https://mblogthumb-phinf.pstatic.net/MjAxOTAzMjlfMjkz/MDAxNTUzODcwNjczMjIx.OC-toAn4Z3ycmhnHUoq9NpFlv3nkJazS8jflE7MP2-cg.ZPH_m-9AMDZ1lZStUW0FzkgvyV0ubY-0LfWOZ_57ercg.JPEG.naya399/%EB%94%B8%EA%B8%B0_%EB%9D%BC%EB%96%BC_%EB%A7%8C%EB%93%A4%EA%B8%B0_(1).jpg?type=w800",
                listOf(
                    Option(
                        "추가 선택",
                        listOf(
                            Check("샷추가", false, 0)
                        ), isCheckBox = true
                    ),

                    Option(
                        "사이즈",
                        listOf(
                            Check("작은거", true, 0),
                            Check("큰거", false, 1000)
                        ), isCheckBox = false
                    )
                )
            ),
            Menu(
                "그냥우유",
                "그냥우유",
                1000,
                "http://kormedi.com/wp-content/uploads/2020/02/gettyimages-973261478-580x580.jpg",
                listOf(
                    Option(
                        "추가 선택",
                        listOf(
                            Check("샷추가", false, 0)
                        ), isCheckBox = true
                    ),

                    Option(
                        "사이즈",
                        listOf(
                            Check("작은거", true, 0),
                            Check("큰거", false, 1000)
                        ), isCheckBox = false
                    )
                )),
            Menu(
                "라떼는 말이야",
                "음,,,아무튼,,라떼는,,맛있단다",
                0,
                "https://mblogthumb-phinf.pstatic.net/MjAxOTEyMjdfMzAw/MDAxNTc3NDI0MDg2MzY4.Wgijw2pa3zhUldQk9qutB0qMugXlyWb2LPoxaAvFBUIg.7nSaROiCGeC19gt9rc5g5vxpQu3cf4xUpbnRCY0ilIcg.JPEG.vipgarden/1577424085453.jpg?type=w800",
                listOf(
                    Option(
                        "추가 선택",
                        listOf(
                            Check("샷추가", false, 0)
                        ), isCheckBox = true
                    ),

                    Option(
                        "사이즈",
                        listOf(
                            Check("작은거", true, 0),
                            Check("큰거", false, 1000)
                        ), isCheckBox = false
                    )
                )
            ),
        )

        store.value = Store(
            "달콤",
            15,
            2,
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