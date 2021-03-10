package io.github.ovso.githubusers.base

import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksViewModel

abstract class MvRxViewModel<S : MavericksState>(initialState: S) : MavericksViewModel<S>(initialState)
