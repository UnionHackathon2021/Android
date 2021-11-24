package kr.hs.dgsw.unionhackathon.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.hs.dgsw.unionhackathon.R
import kr.hs.dgsw.unionhackathon.databinding.FragmentHomeFoodBinding
import kr.hs.dgsw.unionhackathon.ui.adapter.HomeRecyclerViewAdapter

class FoodPizzaFragment : Fragment() {

    /// 가까운 거리 리사이클러뷰
    private val nearAdapter = HomeRecyclerViewAdapter()
    // 나머지
    private val adapter = HomeRecyclerViewAdapter()

    private lateinit var binding: FragmentHomeFoodBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeFoodBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.rvFood.adapter = adapter
        binding.rvNearFood.adapter = nearAdapter

        adapter.setOnClickHomeItemListener {
            navigateToStoreInfo(it)
        }

        nearAdapter.setOnClickHomeItemListener {
            navigateToStoreInfo(it)
        }
    }

    private fun navigateToStoreInfo(id: Int) {
        // todo 대충 storeInfo 로 navigate 하는 코드
    }
}