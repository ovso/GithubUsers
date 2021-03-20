package io.github.ovso.githubusers.data.remote

import io.github.ovso.githubusers.data.remote.model.UserResponse
import io.github.ovso.githubusers.data.remote.model.UserResponse2
import io.github.ovso.githubusers.data.remote.model.UserResponse3

class MainRepositoryImpl constructor(
  private val githubService: GithubService
) : MainRepository {
  override suspend fun getUsers(): List<UserResponse2> {
    return githubService.getUsers()
  }

  override suspend fun getUser(): UserResponse {
    return githubService.getUser()
  }
}
