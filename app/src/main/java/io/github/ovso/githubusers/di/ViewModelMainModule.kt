package io.github.ovso.githubusers.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import io.github.ovso.githubusers.data.remote.GithubService
import io.github.ovso.githubusers.data.remote.MainRepository
import io.github.ovso.githubusers.data.remote.MainRepositoryImpl
import io.github.ovso.githubusers.data.remote.UnsplashService

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelMainModule {

  @Provides
  @ViewModelScoped
  fun provideMainRepository(
    githubService: GithubService,
    unsplashService: UnsplashService
  ): MainRepository {
    return MainRepositoryImpl(
      githubService,
      unsplashService
    )
  }
}
