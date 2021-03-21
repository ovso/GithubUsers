package io.github.ovso.githubusers.data.remote

import io.github.ovso.githubusers.data.remote.model.UserResponse
import io.github.ovso.githubusers.data.remote.model.UserResponse2


interface GithubDataSource {
  suspend fun getUsers(): List<UserResponse2>
  suspend fun getUser(): UserResponse
}
