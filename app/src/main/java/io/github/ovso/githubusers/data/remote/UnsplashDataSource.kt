package io.github.ovso.githubusers.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import io.github.ovso.githubusers.data.remote.model.UnsplashPhoto


class UnsplashDataSource(private val unsplashService: UnsplashService) : PagingSource<Int, UnsplashPhoto>() {
  override fun getRefreshKey(state: PagingState<Int, UnsplashPhoto>): Int? {
    TODO("Not yet implemented")
  }

  override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnsplashPhoto> {
    TODO("Not yet implemented")
  }
}
