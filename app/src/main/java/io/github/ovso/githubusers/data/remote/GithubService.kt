package io.github.ovso.githubusers.data.remote

import io.github.ovso.githubusers.data.remote.model.UserResponse
import retrofit2.http.GET

interface GithubService {
  @GET("users")
  suspend fun getUsers(): List<UserResponse>

  @GET("user")
  suspend fun getUser(): List<UserResponse>

  companion object {

  }
}
