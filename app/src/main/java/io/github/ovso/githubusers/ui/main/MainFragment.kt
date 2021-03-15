package io.github.ovso.githubusers.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import com.orhanobut.logger.Logger
import dagger.hilt.android.AndroidEntryPoint
import io.github.ovso.githubusers.R
import io.github.ovso.githubusers.base.BindingFragment
import io.github.ovso.githubusers.data.prefs.ConfigPreference
import io.github.ovso.githubusers.databinding.FragmentMainBinding
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment : BindingFragment<FragmentMainBinding>(R.layout.fragment_main) {
  override val viewModel by viewModels<MainViewModel>()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val config = ConfigPreference(requireContext())
    viewLifecycleOwner.lifecycleScope.launch {
      config.storeFirstRun(true)
    }

    config.isFirstRun().asLiveData().observe(viewLifecycleOwner) {
      Logger.d("isFirstRun: $it")
    }
  }

}
