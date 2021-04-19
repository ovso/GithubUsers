package io.github.ovso.githubusers.data.remote

import io.github.ovso.githubusers.data.remote.model.UnsplashSearchResponse


interface UnsplashDataSource {
  suspend fun searchPhoto(
    query: String,
    page: Int,
    perPage: Int,
    clientId: String
  ): UnsplashSearchResponse
}
