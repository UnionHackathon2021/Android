package kr.hs.dgsw.unionhackathon.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.unionhackathon.databinding.FragmentReviewBinding
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity.Review
import kr.hs.dgsw.unionhackathon.ui.adapter.ReviewRecyclerViewAdapter
import kr.hs.dgsw.unionhackathon.ui.viewmodel.ReviewViewModel

@AndroidEntryPoint
class ReviewFragment : Fragment() {

    private lateinit var binding: FragmentReviewBinding
    private val adapter = ReviewRecyclerViewAdapter()

    private val viewModel: ReviewViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReviewBinding.inflate(inflater)
        binding.data = null
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getReviews()

        init()
        observe()
    }

    private fun init() {
        binding.rvReview.adapter = adapter
        binding.tvStoreNameReview.text = requireArguments().getString("storeName")
        binding.toolbarReview.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun observe() = with(viewModel) {
        isSuccess.observe(viewLifecycleOwner) {
            binding.data = it

            if (it.reviewResponseList.isEmpty()) {
                binding.layoutEmptyReview.visibility = VISIBLE
                binding.rvReview.visibility = GONE
            } else {
                binding.layoutEmptyReview.visibility = GONE
                binding.rvReview.visibility = VISIBLE

                adapter.setList(it.reviewResponseList)
            }

            // todo 그 표정 바꾸기 ~
        }

        isFailure.observe(viewLifecycleOwner) {
        }
    }
}