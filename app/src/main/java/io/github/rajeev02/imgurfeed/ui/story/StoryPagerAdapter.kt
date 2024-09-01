package io.github.rajeev02.imgurfeed.ui.story

import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.imageLoader
import coil.load
import coil.request.CachePolicy
import coil.request.ImageRequest
import io.github.rajeev02.imgurfeed.ImgurFeedApplication
import io.github.rajeev02.imgurfeed.databinding.PageItemStoryBinding
import io.github.rajeev02.imgurlib.models.common.Image

class StoryPagerAdapter :
    ListAdapter<Image, StoryPagerAdapter.StoryPageViewHolder>(StoryDiffCallback()) {

    class StoryPageViewHolder(val binding: PageItemStoryBinding) :
        RecyclerView.ViewHolder(binding.root)

    class StoryDiffCallback : DiffUtil.ItemCallback<Image>() {
        override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem.id == newItem.id // Assuming 'id' is a unique identifier in 'Image'
        }

        override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem == newItem // If 'Image' is a data class, this checks all properties
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryPageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PageItemStoryBinding.inflate(inflater, parent, false)
        return StoryPageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoryPageViewHolder, position: Int) {
        val height = (holder.binding.root.height ?: 200).coerceAtLeast(200)
        val width = (holder.binding.root.width ?: 200).coerceAtLeast(200)


        val image = getItem(position)
        val imgUrl = if (image.isAlbum == true && image.images?.isNotEmpty() == true) {
            image.images?.get(0)?.link
        } else {
            image.link
        }

        val media = image?.images?.firstOrNull() ?: image

        // Access the global ImageLoader from the Application class
        val imageLoader =
            (holder.binding.root.context.applicationContext as ImgurFeedApplication).imageLoader

        // Preload the image
        val preloadRequest = ImageRequest.Builder(holder.binding.root.context)
            .data(media.link)
            .size(width, height)
            .memoryCacheKey(media.link) // Use a unique cache key based on the media link
            .build()

        imageLoader.enqueue(preloadRequest)

        // Bind the image to the ImageView
        holder.binding.imageUrlTextView.text = media.link?.toString()
        holder.binding.storyImageView.load(media.link) {
            crossfade(true)
            error(android.R.drawable.ic_menu_gallery)
            placeholder(android.R.drawable.ic_menu_gallery)
        }
        holder.binding.progressView.animate()
            .scaleX(1F)
            .setDuration(5000)
            .start()



        // Change the item after 5 seconds
        Handler(Looper.getMainLooper()).postDelayed({
            // Update the item after 5 seconds
            if (position < itemCount) {
                val newImage = getItem(position + 1) // Move to the next item
                val newImgUrl = if (newImage.isAlbum == true && newImage.images?.isNotEmpty() == true) {
                    newImage.images?.get(0)?.link
                } else {
                    newImage.link
                }
                val newMedia = newImage?.images?.firstOrNull() ?: newImage

                // Preload the new image
                val newPreloadRequest = ImageRequest.Builder(holder.binding.root.context)
                    .data(newMedia.link)
                    .size(width, height)
                    .memoryCacheKey(newMedia.link) // Use a unique cache key based on the media link
                    .build()

                imageLoader.enqueue(newPreloadRequest)

                // Bind the new image to the ImageView
                holder.binding.imageUrlTextView.text = newMedia.link?.toString()
                holder.binding.storyImageView.load(newMedia.link) {
                    crossfade(true)
                    error(android.R.drawable.ic_menu_gallery)
                    placeholder(android.R.drawable.ic_menu_gallery)
                }
                holder.binding.progressView.animate()
                    .scaleX(1F)
                    .setDuration(5000)
                    .start()
            }
        }, 5000)

        // Handle

        // Handle different media types
        when (media.type) {
            "image/jpeg", "image/png", "image/gif" -> {
                // Already handled by Coil via ImageLoader
            }

            "video/mp4" -> {
                Log.d("Video Link", media.link.toString())
                // Video handling could be added here if needed, such as using a video player library.
            }

            else -> {
                Log.d("Type", "Unsupported media type")
            }
        }

        cacheNext(holder, position)


//        // Handle click event
//        image.tags?.let { tags ->
//            holder.binding.root.setOnClickListener {
//                holder.binding.root.context.startActivity(
//                    Intent(holder.binding.root.context, StoryActivity::class.java).apply {
//                        putExtra("tag", tags.firstOrNull()?.name)
//                    }
//                )
//            }
//        }
    }

    private fun resetAnimation(progressView: View) {
        progressView.scaleX = 0F
        progressView.animate()
            .scaleX(1F)
            .setDuration(5000)
            .start()
    }


    private fun cacheNext(holder: StoryPageViewHolder, position: Int) {
        val nextPosition = position + 1
        val height = (holder.binding.root.height ?: 200).coerceAtLeast(200)
        val width = (holder.binding.root.width ?: 200).coerceAtLeast(200)


        try {
            val nextimage = getItem(nextPosition)
            val imgUrl = if (nextimage.isAlbum == true && nextimage.images?.isNotEmpty() == true) {
                nextimage?.images?.get(0)?.link
            } else {
                nextimage?.link
            }
            val media = nextimage?.images?.firstOrNull() ?: nextimage

            // Access the global ImageLoader from the Application class
            val imageLoader =
                (holder.binding.root.context.applicationContext as ImgurFeedApplication).imageLoader

            // Preload the image
            val preloadRequest = ImageRequest.Builder(holder.binding.root.context)
                .data(media.link)
                .size(width, height)
                .memoryCacheKey(media.link) // Use a unique cache key based on the media link
                .build()

            // Reset the animation for the new item

            holder.binding.progressView.scaleX= 0F
            holder.binding.progressView.animate().cancel()

            holder.binding.progressView.animate().scaleX(1F).setDuration(5000).setStartDelay(10).start()


            imageLoader.enqueue(preloadRequest)
        } catch (e: Exception) {
            null
        }
    }
}
