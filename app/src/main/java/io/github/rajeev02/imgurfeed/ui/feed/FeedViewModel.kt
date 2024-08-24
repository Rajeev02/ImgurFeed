package io.github.rajeev02.imgurfeed.ui.feed

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.rajeev02.imgurfeed.data.ImgurRepository
import io.github.rajeev02.imgurlib.models.GalleryResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FeedViewModel : ViewModel() {
    private val repo  = ImgurRepository()
    private val _feed = MutableLiveData<List<GalleryResponse.Data?>?>()

    val feed: LiveData<List<GalleryResponse.Data?>?> = _feed


    fun updateFeed(feedType: String){
        viewModelScope.launch ( Dispatchers.IO ){
            when(feedType){
                "hot" -> _feed.postValue(repo.getHotFeed())
                "top" -> _feed.postValue(repo.getTopFeed())
                else  -> Log.e("FEED", "Feed has to be either top or hot")
            }
        }
    }
}