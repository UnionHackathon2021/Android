package kr.hs.dgsw.unionhackathon.ui.fragment

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.transition.TransitionInflater
import coil.load
import com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener
import kr.hs.dgsw.unionhackathon.databinding.FragmentStoreInfoBinding
import kr.hs.dgsw.unionhackathon.ui.adapter.StoreAdapter
import kr.hs.dgsw.unionhackathon.ui.viewmodel.StoreInfoViewModel
import kotlin.math.abs


class StoreInfoFragment : Fragment() {

    private val viewModel: StoreInfoViewModel by viewModels()
    private lateinit var binding: FragmentStoreInfoBinding
    private lateinit var adapter: StoreAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStoreInfoBinding.inflate(inflater)
        binding.vm = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        observe()

        viewModel.getStoreInfo()
    }

    private fun observe() {
        viewModel.store.observe(viewLifecycleOwner) {
            adapter.submitList(it.categoryList)
            binding.ivMainImageStoreInfo.load(it.image)
        }
    }

    private fun init() {
        adapter = StoreAdapter(viewModel)
        binding.rvStoreInfo.adapter = adapter

        binding.appBarLayoutToolbarStoreInfo.addOnOffsetChangedListener(OnOffsetChangedListener { appBarLayout, verticalOffset ->
            if (abs(verticalOffset) - appBarLayout.totalScrollRange >= 0) {
                if (binding.tvStoreNameStoreInfo.alpha != 1f)
                    ObjectAnimator.ofFloat(binding.tvStoreNameStoreInfo, "alpha", 0f, 1f).start()
            } else {
                if (binding.tvStoreNameStoreInfo.alpha != 0f)
                    ObjectAnimator.ofFloat(binding.tvStoreNameStoreInfo, "alpha", 1f, 0f).start()
            }
        })

        binding.toolbarStoreInfo.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }
}