package io.github.ovso.githubusers.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.orhanobut.logger.Logger
import io.github.ovso.githubusers.data.remote.model.UnsplashPhoto
import io.github.ovso.githubusers.data.view.UnsplashItemModel
import io.github.ovso.githubusers.databinding.ItemMainBinding
import javax.inject.Inject

class MainAdapter @Inject constructor() : PagingDataAdapter<UnsplashPhoto, MainViewHolder>(GalleryDiffCallback()) {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
    return MainViewHolder.create(parent)
  }

  override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
    holder.onBindViewHolder(getItem(position))
  }

}

private class GalleryDiffCallback : DiffUtil.ItemCallback<UnsplashPhoto>() {
  override fun areItemsTheSame(oldItem: UnsplashPhoto, newItem: UnsplashPhoto): Boolean {
    return oldItem.id == newItem.id
  }

  override fun areContentsTheSame(oldItem: UnsplashPhoto, newItem: UnsplashPhoto): Boolean {
    return oldItem == newItem
  }
}

class MainViewHolder private constructor(
  private val binding: ItemMainBinding
) : RecyclerView.ViewHolder(binding.root) {

  fun onBindViewHolder(item: UnsplashPhoto?) {
    Logger.d("item: $item")
//    binding.ivMainItem.load(item.user?.)
    binding.ivMainItem.load(item?.urls?.small) {
      crossfade(true)
      crossfade(300)
    }
  }

  companion object {
    fun create(parent: ViewGroup): MainViewHolder {
      return MainViewHolder(
        ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
      )
    }
  }
}
