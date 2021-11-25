package kr.hs.dgsw.unionhackathon.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import kr.hs.dgsw.unionhackathon.databinding.FragmentHomeBinding
import kr.hs.dgsw.unionhackathon.ui.adapter.HomeViewPagerAdapter

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {
        val list = listOf(
            FoodCafeFragment(),
            FoodKoreanFragment(),
            FoodSnackBarFragment(),
            FoodJapaneseFragment(),
            FoodChineseFragment(),
            FoodChickenFragment(),
            FoodPizzaFragment(),
            FoodNightSnackFragment()
        )

        val textList = listOf(
            "카페",
            "한식",
            "분식",
            "일식",
            "중식",
            "치킨",
            "피자",
            "야식/족발/보쌈"
        )

        binding.viewPagerHome.adapter = HomeViewPagerAdapter(list, requireActivity())

        TabLayoutMediator(binding.tabHome, binding.viewPagerHome) { tab, position ->
            tab.text = textList[position]
        }.attach()
    }
}