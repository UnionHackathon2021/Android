package kr.hs.dgsw.unionhackathon.ui.fragment

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.unionhackathon.R
import kr.hs.dgsw.unionhackathon.databinding.FragmentReviewBinding
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity.ReviewList
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

            if (it.reviewList!!.isEmpty()) {
                binding.layoutEmptyReview.visibility = VISIBLE
                binding.rvReview.visibility = GONE
            } else {
                binding.layoutEmptyReview.visibility = GONE
                binding.rvReview.visibility = VISIBLE

                adapter.setList(it.reviewList)
            }

            val colorGrey = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.dark_grey))
            when (getSentiment(it)) {
                "positive" -> {
                    binding.ivPositiveReview.backgroundTintList = null
                    binding.ivNegativeReview.backgroundTintList = colorGrey
                    binding.ivNeutralReview.backgroundTintList = colorGrey
                }

                "neutral" -> {
                    binding.ivPositiveReview.backgroundTintList = colorGrey
                    binding.ivNegativeReview.backgroundTintList = colorGrey
                    binding.ivNeutralReview.backgroundTintList = null
                }

                "negative" -> {
                    binding.ivPositiveReview.backgroundTintList = colorGrey
                    binding.ivNegativeReview.backgroundTintList = null
                    binding.ivNeutralReview.backgroundTintList = colorGrey
                }
            }
        }

        isFailure.observe(viewLifecycleOwner) {
        }
    }

    private fun getSentiment(reviewList: ReviewList): String {
        return if (reviewList.totalPositive > reviewList.totalNegative && reviewList.totalPositive > reviewList.totalNeutral) {
            "positive"
        } else if (reviewList.totalNegative > reviewList.totalPositive && reviewList.totalNegative > reviewList.totalNeutral) {
            "negative"
        } else {
            "neutral"
        }
    }
}