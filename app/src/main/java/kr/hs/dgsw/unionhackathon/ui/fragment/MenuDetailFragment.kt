package kr.hs.dgsw.unionhackathon.ui.fragment

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import coil.load
import com.google.android.material.appbar.AppBarLayout
import kr.hs.dgsw.unionhackathon.R
import kr.hs.dgsw.unionhackathon.databinding.FragmentMenuDetailBinding
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity.Menu
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity.Order
import kr.hs.dgsw.unionhackathon.ui.adapter.OptionAdapter
import kr.hs.dgsw.unionhackathon.ui.viewmodel.MenuDetailViewModel
import kr.hs.dgsw.unionhackathon.ui.viewmodel.StoreInfoViewModel
import kotlin.math.abs

class MenuDetailFragment : Fragment() {

    private val storeInfoViewModel: StoreInfoViewModel by activityViewModels()
    private val viewModel: MenuDetailViewModel by viewModels()
    private lateinit var adapter: OptionAdapter
    private lateinit var binding: FragmentMenuDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuDetailBinding.inflate(inflater)
        binding.vm = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menu = requireArguments().getParcelable<Menu>("menu")

        adapter = OptionAdapter(viewModel)

        if (menu != null) {

            binding.rvOptionMenuDetail.adapter = adapter
            adapter.submitList(menu.option)

            binding.ivMainImageMenuDetail.load(menu.image)
            binding.tvMenuNameMenuDetail.text = menu.title
            binding.tvTotalPriceMenuDetail.text = String.format("%,d원", menu.price)
            binding.tvDetailMenuDetail.text = menu.detail
            binding.tvTitleMenuDetail.text = menu.title

            binding.btnSubNumberMenuDetail.setOnClickListener {
                if (viewModel.number.value ?: 0 > 1) {
                    viewModel.number.value = (viewModel.number.value ?: 0) - 1
                    viewModel.priceEvent.call()
                }
            }
            binding.btnAddNumberMenuDetail.setOnClickListener {
                viewModel.number.value = (viewModel.number.value ?: 0) + 1
                viewModel.priceEvent.call()
            }

            viewModel.priceEvent.observe(viewLifecycleOwner) {
                binding.tvTotalPriceMenuDetail.text = String.format("%,d원", (adapter.getTotalPrice() + menu.price) * (viewModel.number.value ?: 0))
                binding.tvNumberMenuDetail.text = String.format("%d개 추가", viewModel.number.value ?: 0)
            }

            binding.toolbarMenuDetail.setNavigationOnClickListener {
                findNavController().navigateUp()
            }

            binding.btnAddMenuDetail.setOnClickListener {
                findNavController().navigateUp()
                val order = Order(menu.title, adapter.getTotalPrice() + menu.price, menu.detail, viewModel.number.value ?: 0)
                storeInfoViewModel.addOrder(order)
            }

            binding.appBarLayoutToolbarMenuDetail.addOnOffsetChangedListener(
                AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
                    if (abs(verticalOffset) - appBarLayout.totalScrollRange >= 0) {
                        if (binding.tvMenuNameMenuDetail.alpha == 0f)
                            ObjectAnimator.ofFloat(binding.tvMenuNameMenuDetail, "alpha", 0f, 1f)
                                .start()
                    } else {
                        if (binding.tvMenuNameMenuDetail.alpha == 1f)
                            ObjectAnimator.ofFloat(binding.tvMenuNameMenuDetail, "alpha", 1f, 0f)
                                .start()
                    }
                }
            )
        }
    }
}