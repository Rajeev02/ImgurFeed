package io.github.rajeev02.imgurlib.models.common


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Processing(
    @Json(name = "status")
    val status: String? = null
)