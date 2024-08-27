package io.github.rajeev02.imgurfeed.data

import android.annotation.SuppressLint
import android.util.Log
import io.github.rajeev02.imgurlib.ImgurClient
import io.github.rajeev02.imgurlib.models.common.Image
import io.github.rajeev02.imgurlib.models.common.Tag
import io.github.rajeev02.imgurlib.params.Section

class ImgurRepository{
    val api = ImgurClient.api;

    @SuppressLint("SuspiciousIndentation")
    suspend  fun getHotFeed(): List<Image?>? {
      val response =  api.getGallery(Section.HOT)
        response.body()?.data?.toString()?.let {
            Log.d("getHotFeed", it)
        }
      return response.body()?.data
    }

    suspend  fun getTopFeed(): List<Image?>? {
        val response =  api.getGallery(Section.TOP)
        return response.body()?.data
    }

    suspend  fun getTags(): List<Tag?>? {
        val response =  api.getTags()
        return response.body()?.data?.tags
    }
    suspend  fun getTagGallery(tagName: String): List<Image?>? {
        val response =  api.getTagGallery(tagName)
        return response.body()?.data?.items
    }
}
