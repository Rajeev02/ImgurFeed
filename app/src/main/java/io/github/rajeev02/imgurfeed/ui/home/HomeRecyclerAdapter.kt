package io.github.rajeev02.imgurfeed.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import io.github.rajeev02.imgurfeed.databinding.ListItemStoryHeadBinding
import io.github.rajeev02.imgurlib.models.common.Tag

class HomeRecyclerAdapter :
    ListAdapter<Tag, HomeRecyclerAdapter.StoriesViewHolder>(StoriesDiffCallback()) {

    class StoriesViewHolder(val binding: ListItemStoryHeadBinding) : RecyclerView.ViewHolder(binding.root)

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
        holder.binding.storyHeadTextView.text = tag.name

        // Load image using the backgroundHash from Tag
        holder.binding.storyHeadImageView.load("https://i.imgur.com/${tag.backgroundHash}.jpg"){
            crossfade(true)
            error(android.R.drawable.ic_menu_gallery)
            placeholder(android.R.drawable.ic_menu_gallery)
        }
    }
}
