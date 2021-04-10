package io.github.ovso.githubusers.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.orhanobut.logger.Logger
import io.github.ovso.githubusers.databinding.ItemMainBinding
import javax.inject.Inject

class MainAdapter @Inject constructor() : RecyclerView.Adapter<MainViewHolder>() {
  private var items: MutableList<Any> = mutableListOf()
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
    return MainViewHolder.create(parent)
  }

  override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
    holder.onBindViewHolder(items[position])
  }

  override fun getItemCount(): Int = 0
}

class MainViewHolder private constructor(
  private val binding: ItemMainBinding
) : RecyclerView.ViewHolder(binding.root) {

  fun onBindViewHolder(item: Any) {
    Logger.d("item: $item")
  }

  companion object {
    fun create(parent: ViewGroup): MainViewHolder {
      return MainViewHolder(
        ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
      )
    }
  }
}
