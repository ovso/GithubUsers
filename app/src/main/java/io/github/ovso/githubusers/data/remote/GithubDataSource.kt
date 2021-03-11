package io.github.ovso.githubusers.data.remote

import io.github.ovso.githubusers.data.remote.model.UserResponse

interface GithubDataSource {
  fun getUsers(): List<UserResponse>
  fun getUser(): UserResponse
}
