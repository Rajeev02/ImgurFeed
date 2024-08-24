package io.github.rajeev02.imgurlib.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TagsResponse(
    @Json(name = "data")
    val `data`: Data? = null,
    @Json(name = "status")
    val status: Int? = null,
    @Json(name = "success")
    val success: Boolean? = null
) {
    @JsonClass(generateAdapter = true)
    data class Data(
        @Json(name = "featured")
        val featured: String? = null,
        @Json(name = "galleries")
        val galleries: List<Gallery?>? = null,
        @Json(name = "tags")
        val tags: List<Tag?>? = null
    ) {
        @JsonClass(generateAdapter = true)
        data class Gallery(
            @Json(name = "description")
            val description: String? = null,
            @Json(name = "id")
            val id: Int? = null,
            @Json(name = "name")
            val name: String? = null,
            @Json(name = "topPost")
            val topPost: TopPost? = null
        ) {
            @JsonClass(generateAdapter = true)
            data class TopPost(
                @Json(name = "account_id")
                val accountId: Int? = null,
                @Json(name = "account_url")
                val accountUrl: String? = null,
                @Json(name = "ad_type")
                val adType: Int? = null,
                @Json(name = "ad_url")
                val adUrl: String? = null,
                @Json(name = "comment_count")
                val commentCount: Int? = null,
                @Json(name = "cover")
                val cover: String? = null,
                @Json(name = "cover_height")
                val coverHeight: Int? = null,
                @Json(name = "cover_width")
                val coverWidth: Int? = null,
                @Json(name = "datetime")
                val datetime: Int? = null,
                @Json(name = "description")
                val description: Any? = null,
                @Json(name = "downs")
                val downs: Int? = null,
                @Json(name = "favorite")
                val favorite: Any? = null,
                @Json(name = "favorite_count")
                val favoriteCount: Int? = null,
                @Json(name = "id")
                val id: String? = null,
                @Json(name = "images")
                val images: List<Image?>? = null,
                @Json(name = "images_count")
                val imagesCount: Int? = null,
                @Json(name = "in_gallery")
                val inGallery: Boolean? = null,
                @Json(name = "in_most_viral")
                val inMostViral: Boolean? = null,
                @Json(name = "include_album_ads")
                val includeAlbumAds: Boolean? = null,
                @Json(name = "is_ad")
                val isAd: Boolean? = null,
                @Json(name = "is_album")
                val isAlbum: Boolean? = null,
                @Json(name = "layout")
                val layout: String? = null,
                @Json(name = "link")
                val link: String? = null,
                @Json(name = "nsfw")
                val nsfw: Boolean? = null,
                @Json(name = "points")
                val points: Int? = null,
                @Json(name = "privacy")
                val privacy: String? = null,
                @Json(name = "score")
                val score: Int? = null,
                @Json(name = "section")
                val section: String? = null,
                @Json(name = "tags")
                val tags: List<Tag?>? = null,
                @Json(name = "title")
                val title: String? = null,
                @Json(name = "topic")
                val topic: Any? = null,
                @Json(name = "topic_id")
                val topicId: Any? = null,
                @Json(name = "ups")
                val ups: Int? = null,
                @Json(name = "views")
                val views: Int? = null,
                @Json(name = "vote")
                val vote: Any? = null
            ) {
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

                @JsonClass(generateAdapter = true)
                data class Tag(
                    @Json(name = "accent")
                    val accent: String? = null,
                    @Json(name = "background_hash")
                    val backgroundHash: String? = null,
                    @Json(name = "background_is_animated")
                    val backgroundIsAnimated: Boolean? = null,
                    @Json(name = "description")
                    val description: String? = null,
                    @Json(name = "description_annotations")
                    val descriptionAnnotations: DescriptionAnnotations? = null,
                    @Json(name = "display_name")
                    val displayName: String? = null,
                    @Json(name = "followers")
                    val followers: Int? = null,
                    @Json(name = "following")
                    val following: Boolean? = null,
                    @Json(name = "is_promoted")
                    val isPromoted: Boolean? = null,
                    @Json(name = "is_whitelisted")
                    val isWhitelisted: Boolean? = null,
                    @Json(name = "logo_destination_url")
                    val logoDestinationUrl: Any? = null,
                    @Json(name = "logo_hash")
                    val logoHash: Any? = null,
                    @Json(name = "name")
                    val name: String? = null,
                    @Json(name = "thumbnail_hash")
                    val thumbnailHash: Any? = null,
                    @Json(name = "thumbnail_is_animated")
                    val thumbnailIsAnimated: Boolean? = null,
                    @Json(name = "total_items")
                    val totalItems: Int? = null
                ) {
                    @JsonClass(generateAdapter = true)
                    class DescriptionAnnotations
                }
            }
        }

        @JsonClass(generateAdapter = true)
        data class Tag(
            @Json(name = "accent")
            val accent: String? = null,
            @Json(name = "background_hash")
            val backgroundHash: String? = null,
            @Json(name = "background_is_animated")
            val backgroundIsAnimated: Boolean? = null,
            @Json(name = "description")
            val description: String? = null,
            @Json(name = "description_annotations")
            val descriptionAnnotations: DescriptionAnnotations? = null,
            @Json(name = "display_name")
            val displayName: String? = null,
            @Json(name = "followers")
            val followers: Int? = null,
            @Json(name = "following")
            val following: Boolean? = null,
            @Json(name = "is_promoted")
            val isPromoted: Boolean? = null,
            @Json(name = "is_whitelisted")
            val isWhitelisted: Boolean? = null,
            @Json(name = "logo_destination_url")
            val logoDestinationUrl: Any? = null,
            @Json(name = "logo_hash")
            val logoHash: Any? = null,
            @Json(name = "name")
            val name: String? = null,
            @Json(name = "thumbnail_hash")
            val thumbnailHash: String? = null,
            @Json(name = "thumbnail_is_animated")
            val thumbnailIsAnimated: Boolean? = null,
            @Json(name = "total_items")
            val totalItems: Int? = null
        ) {
            @JsonClass(generateAdapter = true)
            data class DescriptionAnnotations(
                @Json(name = "hashtag")
                val hashtag: List<Hashtag?>? = null
            ) {
                @JsonClass(generateAdapter = true)
                data class Hashtag(
                    @Json(name = "indices")
                    val indices: List<Int?>? = null,
                    @Json(name = "tag")
                    val tag: String? = null
                )
            }
        }
    }
}