package io.github.ovso.githubusers.ui.main

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.ovso.githubusers.data.remote.MainRepository
import io.github.ovso.githubusers.data.remote.model.UnsplashPhoto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
  private val repository: MainRepository,
  savedStateHandle: SavedStateHandle
) : ViewModel() {

  fun searchPictures(query: String): Flow<PagingData<UnsplashPhoto>> {
    return repository.getSearchResultStream(query).cachedIn(viewModelScope)
  }
}
