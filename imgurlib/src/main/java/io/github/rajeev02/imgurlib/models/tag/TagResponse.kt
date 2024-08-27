package io.github.rajeev02.imgurlib.models.tag


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TagResponse(
    @Json(name = "data")
    val `data`: Data? = Data(),
    @Json(name = "status")
    val status: Int? = 0,
    @Json(name = "success")
    val success: Boolean? = false
)