package kr.hs.dgsw.unionhackathon.network.responses.responseObj.dto.request

data class VoiceRequest(
    val speaker: String = "nhajun",
    val text: String,
    val volume: Int = 0,
    val speed: Int = 0,
    val pitch: Int = 0,
    val format: String = "mp3"
)
