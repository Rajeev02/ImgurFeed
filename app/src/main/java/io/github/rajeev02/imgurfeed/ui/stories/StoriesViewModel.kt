package io.github.rajeev02.imgurfeed.ui.stories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.rajeev02.imgurfeed.data.ImgurRepository
import io.github.rajeev02.imgurlib.models.TagsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StoriesViewModel : ViewModel() {
    private val repo = ImgurRepository()
    private val _tags = MutableLiveData<List<TagsResponse.Data.Tag?>>()
    val tags: LiveData<List<TagsResponse.Data.Tag?>> = _tags




    fun fetchTags() = viewModelScope.launch ( Dispatchers.IO ) {
        _tags.postValue(repo.getTags())
    }
}