package io.github.ovso.githubusers.data.remote

import io.github.ovso.githubusers.data.remote.model.UserResponse
import io.github.ovso.githubusers.data.remote.model.UserResponse2
import io.github.ovso.githubusers.data.remote.model.UserResponse3

interface MainRepository {
  suspend fun getUsers(): List<UserResponse2>
  suspend fun getUser(): UserResponse
}
