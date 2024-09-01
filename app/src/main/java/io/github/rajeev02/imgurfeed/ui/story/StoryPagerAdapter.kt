package io.github.rajeev02.imgurfeed.ui.story

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.imageLoader
import coil.load
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
        val height = (holder.binding.root.height ?: 200).coerceAtLeast(1)
        val width = (holder.binding.root.width ?: 200).coerceAtLeast(1)


        val image = getItem(position)
        val imgUrl = if (image.isAlbum == true && image.images?.isNotEmpty() == true) {
            image.images?.get(0)?.link
        } else {
            image.link
        }

        val media = image?.images?.firstOrNull() ?: image

        // Access the global ImageLoader from the Application class
        val imageLoader = (holder.binding.root.context.applicationContext as ImgurFeedApplication).imageLoader

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

}

//package io.github.rajeev02.imgurfeed.ui.story
//
//import android.content.Intent
//import android.util.Log
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.ListAdapter
//import androidx.recyclerview.widget.RecyclerView
//import coil.load
//import io.github.rajeev02.imgurfeed.databinding.PageItemStoryBinding
//import io.github.rajeev02.imgurlib.models.common.Image
//
//class StoryPagerAdapter :
//    ListAdapter<Image, StoryPagerAdapter.StoryPageViewHolder>(StoryDiffCallback()) {
//
//    class StoryPageViewHolder(val binding: PageItemStoryBinding) :
//        RecyclerView.ViewHolder(binding.root)
//
//    class StoryDiffCallback : DiffUtil.ItemCallback<Image>() {
//        override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
//            return oldItem.id == newItem.id // Assuming 'id' is a unique identifier in 'Image'
//        }
//
//        override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
//            return oldItem == newItem // If 'Image' is a data class, this checks all properties
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryPageViewHolder {
//        val inflater = LayoutInflater.from(parent.context)
//        val binding = PageItemStoryBinding.inflate(inflater, parent, false)
//        return StoryPageViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: StoryPageViewHolder, position: Int) {
//        val image = getItem(position)
//        val imgUrl = if (image.isAlbum == true && image.images?.isNotEmpty() == true) {
//            image.images?.get(0)?.link
//        } else {
//            image.link
//        }
//
////        imgUrl?.let {
////            holder.binding.storyImageView.load(it) {
////                crossfade(true)
////                error(android.R.drawable.ic_menu_gallery)
////                placeholder(android.R.drawable.ic_menu_gallery)
////            }
////        }
//
//
//        val media = image?.images?.firstOrNull()
//        holder.binding.imageUrlTextView.text = media?.link?.toString()
//        media?.let {
//            when (it.type) {
//                "image/jpeg" -> {
//                    holder.binding.storyImageView.load(it.link) {
//                        crossfade(true)
//                        error(android.R.drawable.ic_menu_gallery)
//                        placeholder(android.R.drawable.ic_menu_gallery)
//                    }
//
//
//                }
//
//                "video/mp4" -> {
//                    Log.d("Video Link", it.link.toString())
//                    // Handle video if needed
//                }
//
//                else -> {
//                    Log.d("Type", "Type Mismatched")
//                }
//            }
//        }
//
//        image.tags?.let { tags ->
//            holder.binding.root.setOnClickListener {
//                holder.binding.root.context.startActivity(
//                    Intent(
//                        holder.binding.root.context,
//                        StoryActivity::class.java
//                    ).apply {
//                        putExtra("tag", tags.firstOrNull()?.name)
//                    })
//            }
//        }
//    }
//}
