package io.github.ovso.githubusers.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.orhanobut.logger.Logger
import io.github.ovso.githubusers.data.view.UnsplashItemModel
import io.github.ovso.githubusers.databinding.ItemMainBinding
import javax.inject.Inject

class MainAdapter @Inject constructor() : RecyclerView.Adapter<MainViewHolder>() {

  var items: MutableList<UnsplashItemModel> = mutableListOf()
    set(value) {
      field.clear()
      field.addAll(value)
      notifyDataSetChanged()
    }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
    return MainViewHolder.create(parent)
  }

  override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
    holder.onBindViewHolder(items[position])
  }

  override fun getItemCount(): Int = items.count()
}

class MainViewHolder private constructor(
  private val binding: ItemMainBinding
) : RecyclerView.ViewHolder(binding.root) {

  fun onBindViewHolder(item: UnsplashItemModel) {
    Logger.d("item: $item")
//    binding.ivMainItem.load(item.user?.)
    binding.ivMainItem.load(item.urls?.small)
  }

  companion object {
    fun create(parent: ViewGroup): MainViewHolder {
      return MainViewHolder(
        ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
      )
    }
  }
}
