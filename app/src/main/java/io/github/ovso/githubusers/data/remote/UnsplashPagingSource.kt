package io.github.ovso.githubusers.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import io.github.ovso.githubusers.data.remote.model.UnsplashPhoto

class UnsplashPagingSource(
  private val service: UnsplashService,
  private val query:String
) : PagingSource<Int, UnsplashPhoto>() {

  override fun getRefreshKey(state: PagingState<Int, UnsplashPhoto>): Int? {
    return state.anchorPosition?.let { anchorPosition ->
      state.closestPageToPosition(anchorPosition)?.nextKey
    }
  }

  override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnsplashPhoto> {
    try {
      val nextPage = params.key ?: 1
      val response = service.searchPhotos(
        query = query,
        page = nextPage,
        perPage = 10,
        clientId = "9_7SmsO0-DGH6oHXHrM-WUpWDXU92JKtsOG1lXzdyf0"
      )

      return LoadResult.Page(
        data = response.results,
        prevKey = if (nextPage == 1) null else nextPage - 1,
        nextKey = nextPage + 1
      )

    } catch (e: Exception) {
      return LoadResult.Error(e)
    }
  }

}
