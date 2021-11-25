package kr.hs.dgsw.unionhackathon.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kr.hs.dgsw.unionhackathon.R
import kr.hs.dgsw.unionhackathon.R.*
import kr.hs.dgsw.unionhackathon.databinding.FragmentOrderBinding

class OrderFragment : Fragment() {

    private lateinit var binding: FragmentOrderBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOrderBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSubmitOrder.setOnClickListener {
            findNavController().navigate(R.id.action_orderFragment_to_createReviewFragment)
        }
    }
}