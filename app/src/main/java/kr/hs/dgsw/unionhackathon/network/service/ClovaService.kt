package kr.hs.dgsw.unionhackathon.network.service

import io.reactivex.Single
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.dto.request.VoiceRequest
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Streaming

interface ClovaService {

    @Streaming
    @POST("tts-premium/v1/tts")
    fun postVoice(voiceRequest: VoiceRequest): Single<Response<ResponseBody>>
}