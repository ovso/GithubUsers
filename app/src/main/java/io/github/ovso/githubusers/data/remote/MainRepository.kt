package io.github.ovso.githubusers.data.remote

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import io.github.ovso.githubusers.data.remote.model.*
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainRepository @Inject constructor(
  private val githubService: GithubService,
  private val unsplashService: UnsplashService
) : GithubDataSource, UnsplashDataSource {

  override suspend fun getUsers(): List<UserResponse2> {
    return githubService.getUsers()
  }

  override suspend fun getUser(): UserResponse {
    return githubService.getUser()
  }

  suspend fun getPhotos(page: Int): List<UnsplashResponse> {
    return unsplashService.getPhotos(page)
  }

  override suspend fun searchPhoto(query: String, page: Int, perPage: Int, clientId: String): UnsplashSearchResponse {
    return unsplashService.searchPhotos(
      query = query,
      page = page,
      perPage = perPage,
      clientId = clientId
    )
  }

  fun getSearchResultStream(query: String): Flow<PagingData<UnsplashPhoto>> {
    return Pager(
      config = PagingConfig(enablePlaceholders = false, pageSize = NETWORK_PAGE_SIZE),
      pagingSourceFactory = {
        UnsplashPagingSource(
          service = unsplashService,
          query = query
        )
      }
    ).flow
  }

  companion object {
    private const val NETWORK_PAGE_SIZE = 25
  }
}
