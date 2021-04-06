package io.github.ovso.githubusers.data.mapper

import io.github.ovso.githubusers.data.remote.model.UnsplashResponse
import io.github.ovso.githubusers.data.view.UnsplashModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


suspend fun List<UnsplashResponse>.toUnsplashModels(): List<UnsplashModel> = withContext(Dispatchers.Default) {
  map {
    UnsplashModel(
      altDescription = it.altDescription,
      blurHash = it.blurHash,
      categories = it.categories,
      color = it.color,
      createdAt = it.createdAt,
      currentUserCollections = it.currentUserCollections,
      description = it.description,
      height = it.height,
      id = it.id,
      likedByUser = it.likedByUser,
      likes = it.likes,
      promotedAt = it.promotedAt,
      links = it.links,
      sponsorship = it.sponsorship,
      updatedAt = it.updatedAt,
      urls = it.urls,
      user = it.user,
      width = it.width
    )
  }
}
