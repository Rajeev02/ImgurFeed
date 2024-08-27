package io.github.rajeev02.imgurfeed.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.rajeev02.imgurfeed.data.ImgurRepository
import io.github.rajeev02.imgurlib.models.common.Image
import io.github.rajeev02.imgurlib.models.common.Tag
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val repo = ImgurRepository()
    private val _tags = MutableLiveData<List<Tag?>>()
    val tags: LiveData<List<Tag?>> = _tags




    fun fetchTags() = viewModelScope.launch ( Dispatchers.IO ) {
        _tags.postValue(repo.getTags())
    }
}