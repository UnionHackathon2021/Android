package kr.hs.dgsw.unionhackathon.network.responses.responseObj.base

data class Response<T>(
    val status: Int,
    val message: String,
    val data: T
)