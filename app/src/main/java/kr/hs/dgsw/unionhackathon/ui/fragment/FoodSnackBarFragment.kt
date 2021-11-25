package kr.hs.dgsw.unionhackathon.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import kr.hs.dgsw.unionhackathon.R
import kr.hs.dgsw.unionhackathon.databinding.FragmentHomeFoodBinding
import kr.hs.dgsw.unionhackathon.ui.adapter.HomeRecyclerViewAdapter
import kr.hs.dgsw.unionhackathon.ui.viewmodel.FoodSnackBarViewModel

class FoodSnackBarFragment : Fragment() {

    private val viewModel: FoodSnackBarViewModel by viewModels()

    // 가까운 거리 리사이클러뷰
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

        if (viewModel.storeList.value == null) {
            viewModel.getStoreList()
        }

        initRecyclerView()
        observe()
    }

    private fun observe() {
        viewModel.nearStoreList.observe(viewLifecycleOwner) {
            nearAdapter.setList(it)
        }
        viewModel.storeList.observe(viewLifecycleOwner) {
            adapter.setList(it)
        }
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
        val bundle = bundleOf("id" to id)
        findNavController().navigate(R.id.action_homeFragment_to_storeInfoFragment, bundle)
    }
}