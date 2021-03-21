package io.github.ovso.githubusers.data.remote

import io.github.ovso.githubusers.data.remote.model.UnsplashResponse
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

  override suspend fun getPhotos(page: Int): List<UnsplashResponse> {
    return unsplashService.getPhotos(page)
  }
}
