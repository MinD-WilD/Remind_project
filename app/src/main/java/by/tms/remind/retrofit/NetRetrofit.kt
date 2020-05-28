package by.tms.remind.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "github.com"
class NetRetrofit {
    private val NetRetrofit: Retrofit

    companion object {
        private var NetRetrofit: Retrofit? = null
        val instance: Retrofit?
            get() {
                if (NetRetrofit == null) {
                }
                return NetRetrofit
            }
    }

    init {
        NetRetrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}