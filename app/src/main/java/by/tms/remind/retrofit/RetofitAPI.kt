package by.tms.remind.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface RetofitAPI {
    @GET("/posts/{id}")
    fun getPostWithID(@Path("id") id: Int): Call<PostRetrofit?>?
}
