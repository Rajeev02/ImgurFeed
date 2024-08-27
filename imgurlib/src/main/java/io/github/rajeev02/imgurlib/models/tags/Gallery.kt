package io.github.rajeev02.imgurlib.models.tags


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.github.rajeev02.imgurlib.models.common.Image

@JsonClass(generateAdapter = true)
data class Gallery(
    @Json(name = "description")
    val description: String? = null,
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "topPost")
    val topPost: Image? = null
)