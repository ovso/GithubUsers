package io.github.ovso.githubusers.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ViewModelMainModule {

/*
  @Binds
  abstract fun provideMainRepository(mainRepository: MainRepositoryImpl):MainRepository
*/
/*
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
*/
}
