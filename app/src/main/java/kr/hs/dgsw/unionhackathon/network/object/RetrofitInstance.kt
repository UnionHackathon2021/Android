package kr.hs.dgsw.unionhackathon.network.`object`

import com.google.gson.Gson
import kr.hs.dgsw.unionhackathon.network.service.ReviewService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val BASE_URL = "http://49.50.172.121:8080/"

    private val gson = Gson().newBuilder().setLenient().create()

    val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    val reviewService = retrofit.create(ReviewService::class.java)
}

