package io.github.rajeev02.imgurlib.models.tag


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.github.rajeev02.imgurlib.models.common.DescriptionAnnotations
import io.github.rajeev02.imgurlib.models.common.Image

@JsonClass(generateAdapter = true)
data class Data(
    @Json(name = "accent")
    val accent: String? = "",
    @Json(name = "background_hash")
    val backgroundHash: String? = "",
    @Json(name = "background_is_animated")
    val backgroundIsAnimated: Boolean? = false,
    @Json(name = "description")
    val description: String? = "",
    @Json(name = "description_annotations")
    val descriptionAnnotations: DescriptionAnnotations? = DescriptionAnnotations(),
    @Json(name = "display_name")
    val displayName: String? = "",
    @Json(name = "followers")
    val followers: Int? = 0,
    @Json(name = "following")
    val following: Boolean? = false,
    @Json(name = "is_promoted")
    val isPromoted: Boolean? = false,
    @Json(name = "is_whitelisted")
    val isWhitelisted: Boolean? = false,
    @Json(name = "items")
    val items: List<Image>? = listOf(),
    @Json(name = "logo_destination_url")
    val logoDestinationUrl: Any? = Any(),
    @Json(name = "logo_hash")
    val logoHash: Any? = Any(),
    @Json(name = "name")
    val name: String? = "",
    @Json(name = "thumbnail_hash")
    val thumbnailHash: Any? = Any(),
    @Json(name = "thumbnail_is_animated")
    val thumbnailIsAnimated: Boolean? = false,
    @Json(name = "total_items")
    val totalItems: Int? = 0
)