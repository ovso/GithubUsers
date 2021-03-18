package io.github.ovso.githubusers.data.remote

import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
  private val githubService: GithubService
) : MainRepository
