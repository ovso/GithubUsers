package io.github.ovso.githubusers.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.ovso.githubusers.data.remote.GithubService
import io.github.ovso.githubusers.data.remote.UnsplashService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

  @Provides
  @Singleton
  fun provideGithubService(): GithubService {
    return GithubService.create()
  }

  @Provides
  @Singleton
  fun provideUnsplashService(): UnsplashService {
    return UnsplashService.create()
  }
}
