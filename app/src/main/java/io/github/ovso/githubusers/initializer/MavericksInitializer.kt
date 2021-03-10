package io.github.ovso.githubusers.initializer

import android.content.Context
import android.util.Log
import androidx.startup.Initializer
import com.airbnb.mvrx.Mavericks

class MavericksInitializer : Initializer<Unit> {
  override fun create(context: Context) {
    Mavericks.initialize(context)
  }

  override fun dependencies(): MutableList<Class<out Initializer<*>>> {
    return mutableListOf()
  }
}
