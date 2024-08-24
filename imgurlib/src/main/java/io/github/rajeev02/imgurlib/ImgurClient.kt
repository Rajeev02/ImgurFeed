package io.github.rajeev02.imgurlib

import io.github.rajeev02.imgurlib.apis.ImgurAPIv3
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ImgurClient {

    const val BASE_URL = "https://api.imgur.com/3/"
    const val API_KEY = "d66376ac6ff83c7" // TODO: ideally should be in app not in lib
    private val httpClient : OkHttpClient by lazy {
        OkHttpClient.Builder()
        .addInterceptor {
            val request = it.request().newBuilder().addHeader(
                "Authorization",
                "Client-ID ${API_KEY}"
            ).build()
            it.proceed(request)
        }.build()
    }

    private val retrofit : Retrofit by lazy {
        Retrofit.Builder()
            .client(httpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    val api : ImgurAPIv3 by lazy {
        retrofit.create(ImgurAPIv3::class.java)
    }
}