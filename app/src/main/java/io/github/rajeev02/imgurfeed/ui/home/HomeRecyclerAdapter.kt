package io.github.rajeev02.imgurfeed.ui.home

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.request.CachePolicy
import coil.request.ImageRequest
import io.github.rajeev02.imgurfeed.ImgurFeedApplication
import io.github.rajeev02.imgurfeed.databinding.ListItemStoryHeadBinding
import io.github.rajeev02.imgurfeed.ui.story.StoryActivity
import io.github.rajeev02.imgurlib.models.common.Tag

class HomeRecyclerAdapter :
    ListAdapter<Tag, HomeRecyclerAdapter.StoriesViewHolder>(StoriesDiffCallback()) {

    class StoriesViewHolder(val binding: ListItemStoryHeadBinding) :
        RecyclerView.ViewHolder(binding.root)

    private class StoriesDiffCallback : DiffUtil.ItemCallback<Tag>() {
        override fun areItemsTheSame(oldItem: Tag, newItem: Tag): Boolean {
            return oldItem.name == newItem.name // Assuming 'id' is a unique identifier in 'Tag'
        }

        override fun areContentsTheSame(oldItem: Tag, newItem: Tag): Boolean {
            return oldItem == newItem // If 'Tag' is a data class, this checks all properties
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoriesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemStoryHeadBinding.inflate(inflater, parent, false)
        return StoriesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoriesViewHolder, position: Int) {
        val tag = getItem(position)

        val height = (holder.binding.root.height ?: 200).coerceAtLeast(200)
        val width = (holder.binding.root.width ?: 200).coerceAtLeast(200)

        Log.d("tag-${position}", tag.toString())
        holder.binding.storyHeadTextView.text = tag.name

        // Access the global ImageLoader from the Application class
        val imageLoader =
            (holder.binding.root.context.applicationContext as ImgurFeedApplication).imageLoader
        val imageUrl = "https://i.imgur.com/${tag.backgroundHash}.jpg"

        // Preload the image
        val preloadRequest = ImageRequest.Builder(holder.binding.root.context)
            .data(imageUrl)
            .size(width, height)
            .memoryCacheKey(imageUrl) // Use a unique cache key based on the image URL
            .build()

        imageLoader.enqueue(preloadRequest)

        // Load the image into ImageView
        holder.binding.storyHeadImageView.load(imageUrl) {
            crossfade(true)
            error(android.R.drawable.ic_menu_gallery)
            placeholder(android.R.drawable.ic_menu_gallery)
        }



        holder.binding.root.setOnClickListener {
            holder.binding.root.context.startActivity(
                Intent(holder.binding.root.context, StoryActivity::class.java).apply {
                    putExtra("tag", tag.name)
                }
            )

        }
    }
}
