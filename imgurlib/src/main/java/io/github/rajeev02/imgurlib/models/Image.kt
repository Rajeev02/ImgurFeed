package io.github.rajeev02.imgurlib.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Image(
    @Json(name = "account_id")
    val accountId: Any? = null,
    @Json(name = "account_url")
    val accountUrl: Any? = null,
    @Json(name = "ad_type")
    val adType: Int? = null,
    @Json(name = "ad_url")
    val adUrl: String? = null,
    @Json(name = "animated")
    val animated: Boolean? = null,
    @Json(name = "bandwidth")
    val bandwidth: Long? = null,
    @Json(name = "comment_count")
    val commentCount: Any? = null,
    @Json(name = "datetime")
    val datetime: Int? = null,
    @Json(name = "description")
    val description: String? = null,
    @Json(name = "downs")
    val downs: Any? = null,
    @Json(name = "edited")
    val edited: String? = null,
    @Json(name = "favorite")
    val favorite: Boolean? = null,
    @Json(name = "favorite_count")
    val favoriteCount: Any? = null,
    @Json(name = "gifv")
    val gifv: String? = null,
    @Json(name = "has_sound")
    val hasSound: Boolean? = null,
    @Json(name = "height")
    val height: Int? = null,
    @Json(name = "hls")
    val hls: String? = null,
    @Json(name = "id")
    val id: String? = null,
    @Json(name = "in_gallery")
    val inGallery: Boolean? = null,
    @Json(name = "in_most_viral")
    val inMostViral: Boolean? = null,
    @Json(name = "is_ad")
    val isAd: Boolean? = null,
    @Json(name = "link")
    val link: String? = null,
    @Json(name = "mp4")
    val mp4: String? = null,
    @Json(name = "mp4_size")
    val mp4Size: Int? = null,
    @Json(name = "nsfw")
    val nsfw: Any? = null,
    @Json(name = "points")
    val points: Any? = null,
    @Json(name = "processing")
    val processing: Processing? = null,
    @Json(name = "score")
    val score: Any? = null,
    @Json(name = "section")
    val section: Any? = null,
    @Json(name = "size")
    val size: Int? = null,
    @Json(name = "tags")
    val tags: List<Any?>? = null,
    @Json(name = "title")
    val title: Any? = null,
    @Json(name = "type")
    val type: String? = null,
    @Json(name = "ups")
    val ups: Any? = null,
    @Json(name = "views")
    val views: Int? = null,
    @Json(name = "vote")
    val vote: Any? = null,
    @Json(name = "width")
    val width: Int? = null
) {
    @JsonClass(generateAdapter = true)
    data class Processing(
        @Json(name = "status")
        val status: String? = null
    )
}