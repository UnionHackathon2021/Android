package kr.hs.dgsw.unionhackathon.network.service

import io.reactivex.Single
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.dto.request.VoiceRequest
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface ClovaService {

    @FormUrlEncoded
    @POST("tts-premium/v1/tts")
    fun postVoice(
        @Field("speaker") speaker: String,
        @Field("text") text: String,
    ): Single<Response<ResponseBody>>
}