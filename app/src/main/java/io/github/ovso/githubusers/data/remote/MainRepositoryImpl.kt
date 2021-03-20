package io.github.ovso.githubusers.data.remote

import io.github.ovso.githubusers.data.remote.model.UserResponse
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
  private val githubService: GithubService
) : MainRepository {
  override suspend fun getUsers(): List<UserResponse> {
    return githubService.getUsers()
  }

  override suspend fun getUser(): UserResponse {
    return githubService.getUser()
  }
}
