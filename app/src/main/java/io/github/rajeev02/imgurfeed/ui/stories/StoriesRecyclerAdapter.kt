package io.github.rajeev02.imgurfeed.ui.stories

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import io.github.rajeev02.imgurfeed.databinding.ListItemStoryHeadBinding
import io.github.rajeev02.imgurlib.models.TagsResponse

class StoriesRecyclerAdapter:
    ListAdapter<TagsResponse.Data.Tag, StoriesRecyclerAdapter.StoriesViewHolder>(StoriesDiffCallBack()) {

    class StoriesViewHolder(val binding: ListItemStoryHeadBinding) : RecyclerView.ViewHolder(binding.root)

  private  class StoriesDiffCallBack : DiffUtil.ItemCallback<TagsResponse.Data.Tag>() {
        override fun areItemsTheSame(
            oldItem: TagsResponse.Data.Tag,
            newItem: TagsResponse.Data.Tag
        ): Boolean {
           return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: TagsResponse.Data.Tag,
            newItem: TagsResponse.Data.Tag
        ): Boolean {
           return oldItem.toString().equals(newItem.toString())
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoriesViewHolder {
        val inflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = ListItemStoryHeadBinding.inflate(inflater, parent, false)
        return StoriesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoriesViewHolder, position: Int) {
        val tag = getItem(position)
        holder.binding.storyHeadTextView.text = tag.name

        //https://i.imgur.com/Sy9ywZe.jpg
        holder.binding.storyHeadImageView.load("https://i.imgur.com/${tag.backgroundHash}.jpg")
    }
}