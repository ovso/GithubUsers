package io.github.ovso.githubusers.ui.main

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.ovso.githubusers.data.remote.MainRepository
import io.github.ovso.githubusers.data.remote.UnsplashPagingSource
import io.github.ovso.githubusers.data.remote.model.UnsplashPhoto
import io.github.ovso.githubusers.data.view.UnsplashItemModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
  private val repository: MainRepository,
  savedStateHandle: SavedStateHandle
) : ViewModel() {

  val photosFlow = MutableStateFlow<List<UnsplashItemModel>>(emptyList())

  private var currentQueryValue: String? = null
  private var currentSearchResult: Flow<PagingData<UnsplashPhoto>>? = null

  fun searchPictures(queryString: String): Flow<PagingData<UnsplashPhoto>> {
    currentQueryValue = queryString
    val newResult: Flow<PagingData<UnsplashPhoto>> =
      repository.getSearchResultStream(queryString).cachedIn(viewModelScope)
    currentSearchResult = newResult
    return newResult
  }

  init {
  }
}
