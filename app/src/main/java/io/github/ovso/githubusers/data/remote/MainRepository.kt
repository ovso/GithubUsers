package io.github.ovso.githubusers.data.remote

import io.github.ovso.githubusers.data.remote.model.UnsplashResponse
import io.github.ovso.githubusers.data.remote.model.UserResponse
import io.github.ovso.githubusers.data.remote.model.UserResponse2
import javax.inject.Inject

class MainRepository @Inject constructor(
  private val githubService: GithubService,
  private val unsplashService: UnsplashService
) : GithubDataSource {
  override suspend fun getUsers(): List<UserResponse2> {
    return githubService.getUsers()
  }

  override suspend fun getUser(): UserResponse {
    return githubService.getUser()
  }

  suspend fun getPhotos(page: Int): List<UnsplashResponse> {
    return unsplashService.getPhotos(page)
  }
}
