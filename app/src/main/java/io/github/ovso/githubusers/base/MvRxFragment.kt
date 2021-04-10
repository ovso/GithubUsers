package io.github.ovso.githubusers.base

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.airbnb.mvrx.MavericksView

abstract class MvRxFragment(@LayoutRes layoutId: Int) : Fragment(layoutId), MavericksView {
  override fun invalidate() {
  }
}
