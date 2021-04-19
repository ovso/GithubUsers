package io.github.ovso.githubusers.ui.main

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.ovso.githubusers.data.remote.MainRepository
import io.github.ovso.githubusers.data.remote.UnsplashPagingSource
import io.github.ovso.githubusers.data.view.UnsplashItemModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
  repository: MainRepository,
  savedStateHandle: SavedStateHandle
) : ViewModel() {

  val photosFlow = MutableStateFlow<List<UnsplashItemModel>>(emptyList())

  init {

    val flow = Pager(PagingConfig(pageSize = 20)) {
      UnsplashPagingSource(repository)
    }


/*
    val flow = Pager(PagingConfig(pageSize = 20)) {
      UnsplashPagingSource(repository)
    }
*/
/*
    viewModelScope.launch {
      val users = repository.getUsers()
      val photos = repository.getPhotos(page = 1).toUnsplashModels()
      photosFlow.value = photos
    }
*/

  }
}
