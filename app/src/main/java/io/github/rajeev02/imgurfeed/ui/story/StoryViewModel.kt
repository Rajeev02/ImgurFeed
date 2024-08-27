package io.github.rajeev02.imgurfeed.ui.story

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.rajeev02.imgurfeed.data.ImgurRepository
import io.github.rajeev02.imgurlib.models.common.Image
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StoryViewModel : ViewModel() {
    private val repo = ImgurRepository()
    private val _images = MutableLiveData<List<Image?>>()

    val images: LiveData<List<Image?>> = _images

    fun fetchTagGallery(tagName: String) = viewModelScope.launch ( Dispatchers.IO ) {
        _images.postValue(repo.getTagGallery(tagName))
    }
}