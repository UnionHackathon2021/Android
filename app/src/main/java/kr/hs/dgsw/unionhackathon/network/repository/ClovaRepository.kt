package kr.hs.dgsw.unionhackathon.network.repository

import android.util.Log
import io.reactivex.Single
import kr.hs.dgsw.unionhackathon.network.responses.response.GetResponses
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.dto.request.VoiceRequest
import kr.hs.dgsw.unionhackathon.network.service.ClovaService
import okhttp3.ResponseBody

class ClovaRepository(override val service: ClovaService) : GetResponses<ClovaService>() {

    fun postVoice(voiceRequest: VoiceRequest): Single<ResponseBody> {
        Log.e("ClovaRepostory", voiceRequest.toString())
        return service.postVoice(voiceRequest).map(getResponse())
    }
}