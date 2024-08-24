package io.github.rajeev02.imgurlib.apis


import io.github.rajeev02.imgurlib.models.GalleryResponse
import io.github.rajeev02.imgurlib.models.TagsResponse
import retrofit2.Call
import retrofit2.http.GET

interface ImgurAPIv3 {

    @GET("gallery/hot?album_previews=true") //TODO: use path params
    fun getGallery(): Call<GalleryResponse>

    @GET("tags")
    fun getTags(): Call<TagsResponse>

}