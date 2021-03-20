package io.github.ovso.githubusers.data.remote

import io.github.ovso.githubusers.data.remote.model.UserResponse

interface MainRepository {
  suspend fun getUsers(): List<UserResponse>
  suspend fun getUser(): UserResponse
}
