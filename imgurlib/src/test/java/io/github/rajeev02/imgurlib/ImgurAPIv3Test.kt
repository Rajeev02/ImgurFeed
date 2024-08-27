package io.github.rajeev02.imgurlib
import io.github.rajeev02.imgurlib.params.Section
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ImgurAPIv3Test {

    val api = ImgurClient.api;

    @Test
    fun `get tags working`() = runBlocking {
        val response =  api.getTags()
//        assert(response.isSuccessful)
        assertNotNull(response.body())
    }

    @Test
    fun `get gallery hot working`() = runBlocking {
        val response =  api.getGallery(Section.HOT)
//        assert(response.isSuccessful)
        assertNotNull(response.body())
    }



    @Test
    fun `get gallery top working`() = runBlocking {
        val response =  api.getGallery(Section.TOP)
//        assert(response.isSuccessful)
        assertNotNull(response.body())
    }
    @Test
    fun `get tag - trees - gallery working`() = runBlocking {
        val response =  api.getTagGallery("trees")
        assertNotNull(response.body())
    }
}