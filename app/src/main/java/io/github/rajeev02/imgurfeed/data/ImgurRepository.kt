package io.github.rajeev02.imgurfeed.data

import android.util.Log
import io.github.rajeev02.imgurlib.ImgurClient
import io.github.rajeev02.imgurlib.models.GalleryResponse
import io.github.rajeev02.imgurlib.params.Section

class ImgurRepository{
    val api = ImgurClient.api;

    suspend  fun getHotFeed(): List<GalleryResponse.Data?>? { //TODO: return a proper error object if null
      val response =  api.getGallery(Section.HOT)
        response.body()?.data?.toString()?.let {
            Log.d("getHotFeed", it)
        }
      return response.body()?.data
    }

    suspend  fun getTopFeed(): List<GalleryResponse.Data?>? { //TODO: return a proper error object if null
        val response =  api.getGallery(Section.TOP)
        return response.body()?.data
    }
}
