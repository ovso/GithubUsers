package io.github.ovso.githubusers.ui.main

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orhanobut.logger.Logger
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.ovso.githubusers.data.mapper.toUnsplashModels
import io.github.ovso.githubusers.data.remote.MainRepository
import io.github.ovso.githubusers.data.view.UnsplashModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
  repository: MainRepository,
  savedStateHandle: SavedStateHandle
) : ViewModel() {

  val photosFlow = MutableStateFlow<List<UnsplashModel>>(emptyList())

  init {
    Logger.d("repository: $repository")
    Logger.d("savedStateHandle: $savedStateHandle")
    viewModelScope.launch {
      val users = repository.getUsers()
      Logger.d("users count: ${users.count()}")
      val photos = repository.getPhotos(page = 1).toUnsplashModels()
      photosFlow.value = photos
    }
  }
}
