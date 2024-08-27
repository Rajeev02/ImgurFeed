package io.github.rajeev02.imgurlib.models.gallery


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.github.rajeev02.imgurlib.models.common.Image

@JsonClass(generateAdapter = true)
data class GalleryResponse(
    @Json(name = "data")
    val `data`: List<Image>? = listOf(),
    @Json(name = "status")
    val status: Int? = 0,
    @Json(name = "success")
    val success: Boolean? = false
)