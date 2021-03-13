package io.github.ovso.githubusers.ui.main

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import io.github.ovso.githubusers.R
import io.github.ovso.githubusers.base.BindingFragment
import io.github.ovso.githubusers.databinding.FragmentMainBinding

@AndroidEntryPoint
class MainFragment : BindingFragment<FragmentMainBinding>(R.layout.fragment_main) {
  override val viewModel by viewModels<MainViewModel>()

}
