package io.github.rajeev02.imgurlib.params

import com.squareup.moshi.Json

enum class Section {
    @Json(name = "hot") HOT,
    @Json(name = "top") TOP,
}