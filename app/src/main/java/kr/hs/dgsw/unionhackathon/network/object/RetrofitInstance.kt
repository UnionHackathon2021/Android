package kr.hs.dgsw.unionhackathon.network.`object`

import com.google.gson.Gson
import kr.hs.dgsw.unionhackathon.network.service.ClovaService
import kr.hs.dgsw.unionhackathon.network.service.ReviewService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "http://49.50.172.121:8080/"
    private const val CLOVA_BASE_URL = "https://naveropenapi.apigw.ntruss.com/"

    private val gson = Gson().newBuilder().setLenient().create()

    private val client = OkHttpClient.Builder().addInterceptor(KeyInterceptor()).build()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    private val clovaRetrofit by lazy {
        Retrofit.Builder()
            .baseUrl(CLOVA_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()
    }

    val reviewService: ReviewService = retrofit.create(ReviewService::class.java)
    val clovaService: ClovaService = clovaRetrofit.create(ClovaService::class.java)
}

class KeyInterceptor : Interceptor {
    private val CLOVA_CLIENT_ID = "hgk845utox"
    private val CLOVA_CLIENT_SECRET = "Auend329Xbf9V339eKZkDfMoDQjjqLDSlGqPMhTj"

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("X-NCP-APIGW-API-KEY-ID", CLOVA_CLIENT_ID)
            .addHeader("X-NCP-APIGW-API-KEY", CLOVA_CLIENT_SECRET)
            .build()

        return chain.proceed(request)
    }
}