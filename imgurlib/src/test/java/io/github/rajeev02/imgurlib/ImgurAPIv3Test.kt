package io.github.rajeev02.imgurlib
import org.junit.Test

class ImgurAPIv3Test {

    val api = ImgurClient.api;

    @Test
    fun `get tags working`(){
        val response =  api.getTags().execute()
        assert(response.isSuccessful)
    }

    @Test
    fun `get gallery working`(){
        val response =  api.getGallery().execute()
        assert(response.isSuccessful)
    }
}