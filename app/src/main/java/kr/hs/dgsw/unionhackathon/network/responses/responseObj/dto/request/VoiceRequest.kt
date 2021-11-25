package kr.hs.dgsw.unionhackathon.network.responses.responseObj.dto.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class VoiceRequest(
    val speaker: String,
    val text: String,
)
