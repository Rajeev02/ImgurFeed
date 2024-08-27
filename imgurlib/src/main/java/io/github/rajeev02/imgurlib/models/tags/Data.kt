package io.github.rajeev02.imgurlib.models.tags


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.github.rajeev02.imgurlib.models.common.Tag

@JsonClass(generateAdapter = true)
data class Data(
    @Json(name = "featured")
    val featured: String? = "",
    @Json(name = "galleries")
    val galleries: List<Gallery>? = listOf(),
    @Json(name = "tags")
    val tags: List<Tag>? = listOf()
)