package kr.hs.dgsw.unionhackathon.network.repository

import android.util.Log
import io.reactivex.Single
import kr.hs.dgsw.unionhackathon.network.responses.response.GetResponses
import kr.hs.dgsw.unionhackathon.network.responses.responseObj.dto.request.VoiceRequest
import kr.hs.dgsw.unionhackathon.network.service.ClovaService
import okhttp3.ResponseBody

class ClovaRepository(override val service: ClovaService) : GetResponses<ClovaService>() {

    fun postVoice(speaker: String, text: String): Single<ResponseBody> {
        return service.postVoice(speaker, text).map(getResponse())
    }
}