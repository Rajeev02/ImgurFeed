package io.github.rajeev02.imgurlib.apis


import io.github.rajeev02.imgurlib.models.GalleryResponse
import io.github.rajeev02.imgurlib.models.TagsResponse
import io.github.rajeev02.imgurlib.params.Section
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ImgurAPIv3 {

    @GET("gallery/{section}") //TODO: use path params
    suspend fun getGallery(
        @Path("section") section: Section? = Section.HOT,
        @Query("album_previews") album_previews: Boolean? = true
    ): Response<GalleryResponse>

    @GET("tags")
   suspend fun getTags(): Response<TagsResponse>

}