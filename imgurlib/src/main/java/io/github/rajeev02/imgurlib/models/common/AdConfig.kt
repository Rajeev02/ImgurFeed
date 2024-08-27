package io.github.rajeev02.imgurlib.models.common


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AdConfig(
    val highRiskFlags: List<Any>?,
    val nsfwScore: Double?,
    val safeFlags: List<String>?,
    val showAdLevel: Int?,
    val showAds: Boolean?,
    val unsafeFlags: List<String>?,
    val wallUnsafeFlags: List<String>?
) {
    constructor(
        @Json(name = "highRiskFlags") highRiskFlags1: List<Any>? = null,
        @Json(name = "high_risk_flags") highRiskFlags2: List<Any>? = null,
        @Json(name = "nsfw_score") nsfwScore: Double? = null,
        @Json(name = "safeFlags") safeFlags1: List<String>? = null,
        @Json(name = "safe_flags") safeFlags2: List<String>? = null,
        @Json(name = "showAdLevel") showAdLevel1: Int? = null,
        @Json(name = "show_ad_level") showAdLevel2: Int? = null,
        @Json(name = "show_ads") showAds1: Boolean? = null,
        @Json(name = "showsAds") showAds2: Boolean? = null,
        @Json(name = "unsafeFlags") unsafeFlags1: List<String>? = null,
        @Json(name = "unsafe_flags") unsafeFlags2: List<String>? = null,
        @Json(name = "wallUnsafeFlags") wallUnsafeFlags1: List<String>? = null,
        @Json(name = "wall_unsafe_flags") wallUnsafeFlags2: List<String>? = null,
    ) : this(
        highRiskFlags1 ?: highRiskFlags2 ?: emptyList(),
        nsfwScore,
        safeFlags1 ?: safeFlags2 ?: emptyList(),
        showAdLevel1 ?: showAdLevel2 ?: 0,
        showAds1 ?: showAds2 ?: false,
        unsafeFlags1 ?: unsafeFlags2 ?: emptyList(),
        wallUnsafeFlags1 ?: wallUnsafeFlags2 ?: emptyList()
    )
}
