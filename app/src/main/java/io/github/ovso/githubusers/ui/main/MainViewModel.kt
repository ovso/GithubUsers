package io.github.ovso.githubusers.ui.main

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orhanobut.logger.Logger
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.ovso.githubusers.data.remote.MainRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
  repository: MainRepository,
  savedStateHandle: SavedStateHandle
) : ViewModel() {

  init {
    Logger.d("repository: $repository")
    Logger.d("savedStateHandle: $savedStateHandle")
    viewModelScope.launch {
      Logger.d("Thread name: ${Thread.currentThread().name}")
      val users = repository.getUsers()
      Logger.d("users: ${users.count()}")
    }
  }
}
