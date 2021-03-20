package io.github.ovso.githubusers.ui.main

import androidx.lifecycle.ViewModel
import com.orhanobut.logger.Logger
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.ovso.githubusers.data.remote.MainRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
  repository: MainRepository
) : ViewModel() {

  init {
    Logger.d("repository: $repository")
  }
}
