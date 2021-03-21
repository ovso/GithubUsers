package io.github.ovso.githubusers.data.remote

import com.google.gson.JsonElement

interface UnsplashDataSource {
  suspend fun getPhotos(): List<JsonElement>
}
