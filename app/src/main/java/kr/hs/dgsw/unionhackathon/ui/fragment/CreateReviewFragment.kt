package kr.hs.dgsw.unionhackathon.ui.fragment

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.unionhackathon.R
import kr.hs.dgsw.unionhackathon.databinding.FragmentCreateReviewBinding
import kr.hs.dgsw.unionhackathon.ui.viewmodel.CreateReviewViewModel
import okhttp3.ResponseBody
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.util.jar.Manifest

@AndroidEntryPoint
class CreateReviewFragment : Fragment() {

    private val navController: NavController by lazy {
        findNavController()
    }

    private lateinit var binding: FragmentCreateReviewBinding
    private val viewModel: CreateReviewViewModel by viewModels()

    private lateinit var mediaPlayer: MediaPlayer

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
            val content = binding.etContentReview.text

            if (content.isNullOrBlank()) {
                Toast.makeText(requireContext(), "리뷰를 입력해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.postCreateReview(content.toString())
            }
        }

        binding.btnSoundCreateReview.setOnClickListener {
            val text = binding.etContentReview.text

            if (!text.isNullOrBlank())
                viewModel.postVoice(text.toString())
        }

        binding.btnSoundStopCreateReview.setOnClickListener {
            setSoundPlayButtonVisible()

            mediaPlayer.stop()
        }

    }

    private fun observe() = with(viewModel) {
        isSuccess.observe(viewLifecycleOwner) {
            setSoundStopButtonVisible()

            val path = saveFile(it, "\\test.mp3")
            initMediaPlayer(path)

            if (!mediaPlayer.isLooping && !mediaPlayer.isPlaying)
                mediaPlayer.start()
        }

        isFailure.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), "다시 시도해주세요.", Toast.LENGTH_SHORT).show()
        }

        isSuccessCreate.observe(viewLifecycleOwner) {
            navController.navigateUp()
        }
    }

    private fun saveFile(body: ResponseBody, path: String): String {
        var input: InputStream? = null

        try {
            input = body.byteStream()

            val file = File(requireActivity().application.filesDir.path + path)

            val fos = FileOutputStream(file)
            fos.use { output ->
                val buffer = ByteArray(4 * 1024) // or other buffer size
                var read: Int
                while (input.read(buffer).also { read = it } != -1) {
                    output.write(buffer, 0, read)
                }
                output.flush()
            }

            return file.path
        } catch (e:Exception){
            Log.e("saveFile", e.toString())
        } finally {
            input?.close()
        }

        return ""
    }

    private fun initMediaPlayer(path: String) {
        mediaPlayer = MediaPlayer.create(requireContext(), Uri.parse(path))

        mediaPlayer.setOnCompletionListener {
            setSoundPlayButtonVisible()
        }
    }

    private fun setSoundPlayButtonVisible() {
        binding.btnSoundCreateReview.visibility = VISIBLE
        binding.btnSoundStopCreateReview.visibility = GONE
    }

    private fun setSoundStopButtonVisible() {
        binding.btnSoundCreateReview.visibility = GONE
        binding.btnSoundStopCreateReview.visibility = VISIBLE
    }
}