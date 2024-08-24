package io.github.rajeev02.imgurlib
import io.github.rajeev02.imgurlib.params.Section
import org.junit.Test

class ImgurAPIv3Test {

    val api = ImgurClient.api;

    @Test
    fun `get tags working`(){
        val response =  api.getTags().execute()
        assert(response.isSuccessful)
    }

    @Test
    fun `get gallery hot working`(){
        val response =  api.getGallery(Section.HOT).execute()
        assert(response.isSuccessful)
    }

    @Test
    fun `get gallery top working`(){
        val response =  api.getGallery(Section.TOP).execute()
        assert(response.isSuccessful)
    }
}