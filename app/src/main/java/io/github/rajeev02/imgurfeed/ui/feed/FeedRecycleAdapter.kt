package io.github.rajeev02.imgurfeed.ui.feed

import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import io.github.rajeev02.imgurfeed.databinding.ListItemGalleryImageBinding
import io.github.rajeev02.imgurfeed.ui.story.StoryActivity
import io.github.rajeev02.imgurlib.models.common.Image

class FeedRecycleAdapter :
    ListAdapter<Image, FeedRecycleAdapter.FeedViewHolder>(FeedDiffCallback()) {

    class FeedViewHolder(val binding: ListItemGalleryImageBinding) :
        RecyclerView.ViewHolder(binding.root)

    private class FeedDiffCallback : DiffUtil.ItemCallback<Image>() {
        override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem.id == newItem.id // Compare by a unique identifier if available
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
            // Compare relevant fields or properties here
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemGalleryImageBinding.inflate(inflater, parent, false)
        return FeedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val image = getItem(position)
        Log.d("FeedAdapter", image.toString())

        holder.binding.textView.text = image?.title.toString()

        val media = image?.images?.firstOrNull()
        media?.let {
            when (it.type) {
                "image/jpeg" -> {
                    holder.binding.imageView.load(it.link) {
                        crossfade(true)
                        error(android.R.drawable.ic_menu_gallery)
                        placeholder(android.R.drawable.ic_menu_gallery)
                    }
                }
                "video/mp4" -> {
                    Log.d("Video Link", it.link.toString())
                    // Handle video if needed
                }

                else -> {
                    Log.d("Type","Type Mismatched")
                }
            }
        }

        image.tags?.let { tags ->
            holder.binding.root.setOnClickListener {
                holder.binding.root.context.startActivity(Intent(holder.binding.root.context, StoryActivity::class.java).apply {
                    putExtra("tag", tags.firstOrNull()?.name)
                })
            }
        }
    }
}
