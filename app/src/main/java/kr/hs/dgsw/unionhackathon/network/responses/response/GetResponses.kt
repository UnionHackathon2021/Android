package kr.hs.dgsw.unionhackathon.network.responses.response

import android.util.Log
import com.google.gson.Gson
import io.reactivex.functions.Function

abstract class GetResponses<SV> {
    abstract val service: SV

    fun <T> getResponse(): Function<retrofit2.Response<T>, T> {
        return Function {
            checkError(it)
            it.body()
        }
    }

    fun <T> getMessage(): Function<retrofit2.Response<T>, String> {
        return Function {
            checkError(it)
            it.code().toString()
        }
    }

    private fun <T> checkError(response: retrofit2.Response<T>) {
        if (!response.isSuccessful) {
            Log.e("errorBody", "${response.message()}, ${response.errorBody()!!.string()}")
            val gson = Gson()
            throw Throwable(response.code().toString())
        }
    }
}