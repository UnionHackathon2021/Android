package kr.hs.dgsw.unionhackathon.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kr.hs.dgsw.unionhackathon.databinding.FragmentReviewBinding
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.entity.Review
import kr.hs.dgsw.unionhackathon.ui.adapter.ReviewRecyclerViewAdapter

class ReviewFragment : Fragment() {

    private lateinit var binding: FragmentReviewBinding
    private val adapter = ReviewRecyclerViewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReviewBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {
        binding.rvReview.adapter = adapter
        binding.tvStoreNameReview.text = requireArguments().getString("storeName")
        binding.toolbarReview.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        val dummyList = listOf(
            Review("닉네임", 10, 40, 50, "negative", "졸려요~", listOf("마싯는 마라탕", "하하")),
            Review("닉네임", 90, 5, 5, "positive","졸려요~", listOf("마싯는 마라탕", "하하"))
        )

        adapter.setList(dummyList)
    }
}