package io.github.rajeev02.imgurlib.models.common


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Hashtag(
    @Json(name = "indices")
    val indices: List<Int?>? = null,
    @Json(name = "tag")
    val tag: String? = null
)