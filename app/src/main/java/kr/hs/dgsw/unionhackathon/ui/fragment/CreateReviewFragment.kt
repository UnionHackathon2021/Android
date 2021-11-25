package kr.hs.dgsw.unionhackathon.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.unionhackathon.R
import kr.hs.dgsw.unionhackathon.databinding.FragmentCreateReviewBinding
import kr.hs.dgsw.unionhackathon.ui.viewmodel.CreateReviewViewModel
import okhttp3.ResponseBody
import java.io.FileOutputStream
import java.io.InputStream

@AndroidEntryPoint
class CreateReviewFragment : Fragment() {

    private val navController: NavController by lazy {
        findNavController()
    }

    private lateinit var binding: FragmentCreateReviewBinding
    private val viewModel: CreateReviewViewModel by viewModels()
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateReviewBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe()

        binding.btnBackCreateReview.setOnClickListener {
            navController.navigate(R.id.action_createReviewFragment_to_storeInfoFragment)
        }

        binding.btnConfirmCreateReview.setOnClickListener {
            viewModel.postVoice()
//            if (viewModel.content.value.isNullOrBlank()) {
//                Toast.makeText(requireContext(), "리뷰를 입력해주세요.", Toast.LENGTH_SHORT).show()
//            } else {
//                viewModel.postVoice()
//            }
        }
    }

    private fun observe() = with(viewModel) {
        isSuccess.observe(viewLifecycleOwner) {
            saveFile(it, "C:\\Github\\UnionHackathon2021\\mp3")
        }

        isFailure.observe(viewLifecycleOwner) {

        }
    }

    private fun saveFile(body: ResponseBody, path: String): String {
        var input: InputStream? = null
        try {
            input = body.byteStream()
            val fos = FileOutputStream(path)
            fos.use { output ->
                val buffer = ByteArray(4 * 1024) // or other buffer size
                var read: Int
                while (input.read(buffer).also { read = it } != -1) {
                    output.write(buffer, 0, read)
                }
                output.flush()
            }

            return path
        } catch (e:Exception){
            Log.e("saveFile", e.toString())
        } finally {
            input?.close()
        }

        return ""
    }
}