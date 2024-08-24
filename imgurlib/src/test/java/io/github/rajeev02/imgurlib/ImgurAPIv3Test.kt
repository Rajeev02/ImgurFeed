package io.github.rajeev02.imgurlib

import io.github.rajeev02.imgurlib.apis.ImgurAPIv3
import okhttp3.OkHttpClient
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ImgurAPIv3Test {

        private val client = OkHttpClient.Builder()
            .addInterceptor {
                val request = it.request().newBuilder().addHeader(
                    "Authorization",
                    "Client-ID d66376ac6ff83c7"
                ).build()
                it.proceed(request)
            }.build()


        private val retrofit = Retrofit.Builder()
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl("https://api.imgur.com/3/")
            .build()
        private val api  = retrofit.create(ImgurAPIv3::class.java)


        @Test
        fun `get tags working`(){
            val response =  api.getTags().execute()
            assert(response.isSuccessful)
//        assertNotNull(response.body())

        }

        @Test
        fun `get gallery working`(){
            val response =  api.getGallery().execute()
            assert(response.isSuccessful)
//        assertNotNull(response.body())
        }

    }