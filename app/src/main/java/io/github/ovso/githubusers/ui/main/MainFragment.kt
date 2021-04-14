package io.github.ovso.githubusers.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import com.orhanobut.logger.Logger
import dagger.hilt.android.AndroidEntryPoint
import io.github.ovso.githubusers.R
import io.github.ovso.githubusers.base.BaseFragment
import io.github.ovso.githubusers.base.viewBinding
import io.github.ovso.githubusers.data.prefs.ConfigPreference
import io.github.ovso.githubusers.databinding.FragmentMainBinding
import io.github.ovso.githubusers.ui.main.adapter.MainAdapter
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : BaseFragment(R.layout.fragment_main) {

  private val viewModel: MainViewModel by viewModels()
  private val binding: FragmentMainBinding by viewBinding()

  @Inject lateinit var adapter:MainAdapter

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val config = ConfigPreference(requireContext())
    viewLifecycleOwner.lifecycleScope.launch {
      config.storeFirstRun(true)
    }

    config.isFirstRun().asLiveData().observe(viewLifecycleOwner) {
      Logger.d("isFirstRun: $it")
    }
    observe()
    setupRv()
    Logger.d("adapter: $adapter")
  }

  private fun setupRv() {
    binding.root.adapter = adapter
  }

  private fun observe() {
    val owner = viewLifecycleOwner
    viewModel.photosFlow.asLiveData().observe(owner) {
      Logger.d("fragment count: ${it.count()}")
//      adapter.items = it.toMutableList()
    }

  }
}
