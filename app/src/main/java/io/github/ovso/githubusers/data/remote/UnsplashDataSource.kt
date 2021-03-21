package io.github.ovso.githubusers.data.remote

import io.github.ovso.githubusers.data.remote.model.UnsplashResponse

interface UnsplashDataSource {
  suspend fun getPhotos(page: Int = 1): List<UnsplashResponse>
}
