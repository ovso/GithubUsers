package io.github.ovso.githubusers

import android.app.Application
import com.airbnb.mvrx.Mavericks
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GithubUsersApp : Application() {
  override fun onCreate() {
    super.onCreate()
//    Mavericks.initialize(this)
  }
}
