package kr.hs.dgsw.unionhackathon.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.hs.dgsw.unionhackathon.R
import kr.hs.dgsw.unionhackathon.databinding.FragmentCreateReviewBinding

class CreateReviewFragment : Fragment() {

    private lateinit var binding: FragmentCreateReviewBinding
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateReviewBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBackCreateReview.setOnClickListener {
            // todo storeInfo 로 navigate
        }

        binding.btnConfirmCreateReview.setOnClickListener {
            // todo 서버 연동
        }
    }
}