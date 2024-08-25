package io.github.rajeev02.imgurfeed.ui.feed

import android.annotation.SuppressLint
import android.app.LauncherActivity.ListItem
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import io.github.rajeev02.imgurfeed.databinding.ListItemGalleryImageBinding
import io.github.rajeev02.imgurlib.models.GalleryResponse
import io.github.rajeev02.imgurlib.models.GalleryResponse.*
import io.github.rajeev02.imgurlib.models.Image

class FeedRecycleAdapter() :
    ListAdapter<Data, FeedRecycleAdapter.FeedViewHolder>(FeedDiffCallBack()) {
        class FeedViewHolder(val binding: ListItemGalleryImageBinding) : RecyclerView.ViewHolder(binding.root)

   private class FeedDiffCallBack : DiffUtil.ItemCallback<Data>() {
       override fun areItemsTheSame(
           oldItem: Data,
           newItem: Data
       ): Boolean {
          return oldItem == newItem
       }

       @SuppressLint("DiffUtilEquals")
       override fun areContentsTheSame(
           oldItem: Data,
           newItem: Data
       ): Boolean {
        //   return  oldItem === newItem
         return  oldItem.toString().equals(newItem.toString())
       }
   }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {

        val inflater = parent.context.getSystemService(LayoutInflater::class.java)
//        val  inflater = LayoutInflater.from(parent.context)

       val binding =  ListItemGalleryImageBinding.inflate(inflater, parent, false)
        return  FeedViewHolder(binding);
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {

        val data = getItem(position)
        Log.d("daaartaa", data.toString())
        holder.binding.textView.text = data.title
        if(data.images?.get(0)?.type.equals("image/jpeg")) {
            holder.binding.imageView.load(data.images?.get(0)?.link) {
                crossfade(true)
                error(android.R.drawable.ic_menu_gallery)
                placeholder(android.R.drawable.ic_menu_gallery)
            }
        } else if(data.images?.get(0)?.type.equals("video/mp4")) {
            Log.d("Video Link", data.images?.get(0)?.link.toString())

        }


    //      val data = getItem(position)
//
//        Log.d("onBindViewHolder", data.toString())
//      holder.binding.textView.text = data.title
//        holder.binding.imageView.load(data.images?.get(0)?.link)
//        holder.binding.tvDescription.text = data.description
//        holder.binding.tvSection.text = data.section
//        holder.binding.tvViews.text = data.views.toString()
//        holder.binding.tvPoints.text = data.points.toString()
//        holder.binding.tvDatetime.text = data.datetime.toString()
//        holder.binding.tvScore.text = data.score.toString()
//        holder.binding.tvUps.text = data.ups.toString()
//        holder.binding.tvDowns.text = data.downs.toString()
//        holder.binding.tvComments.text = data.commentCount.toString()
//        holder.binding.tvFavoriteCount.text = data.favoriteCount.toString()
//        holder.binding.tvTags.text = data.tags.toString()

    }
}