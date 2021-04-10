package io.github.ovso.githubusers.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.ovso.githubusers.databinding.ItemMainBinding

class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
    return MainViewHolder.create(parent)
  }

  override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
  }

  override fun getItemCount(): Int = 0
}

class MainViewHolder private constructor(
  private val binding: ItemMainBinding
) : RecyclerView.ViewHolder(binding.root) {

  fun onBindViewHolder() {
  }

  companion object {
    fun create(parent: ViewGroup): MainViewHolder {
      return MainViewHolder(
        ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
      )
    }
  }
}
