package io.github.rajeev02.imgurfeed.ui.story

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import io.github.rajeev02.imgurfeed.databinding.PageItemStoryBinding
import io.github.rajeev02.imgurlib.models.common.Image

class StoryPagerAdapter :
    ListAdapter<Image, StoryPagerAdapter.StoryPageViewHolder>(StoryDiffCallback()) {

    class StoryPageViewHolder(val binding: PageItemStoryBinding) : RecyclerView.ViewHolder(binding.root)

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
        val image = getItem(position)
        val imgUrl = if (image.isAlbum == true && image.images?.isNotEmpty() == true) {
            image.images?.get(0)?.link
        } else {
            image.link
        }

        imgUrl?.let {
            holder.binding.storyImageView.load(it) {
                crossfade(true)
                error(android.R.drawable.ic_menu_gallery)
                placeholder(android.R.drawable.ic_menu_gallery)
            }
        }
    }
}
