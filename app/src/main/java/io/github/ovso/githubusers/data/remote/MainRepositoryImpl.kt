package io.github.ovso.githubusers.data.remote

import com.google.gson.JsonElement
import io.github.ovso.githubusers.data.remote.model.UserResponse
import io.github.ovso.githubusers.data.remote.model.UserResponse2

class MainRepositoryImpl constructor(
  private val githubService: GithubService,
  private val unsplashService: UnsplashService
) : MainRepository {
  override suspend fun getUsers(): List<UserResponse2> {
    return githubService.getUsers()
  }

  override suspend fun getUser(): UserResponse {
    return githubService.getUser()
  }

  override suspend fun getPhotos(): List<JsonElement> {
    return unsplashService.getPhotos()
  }
}
