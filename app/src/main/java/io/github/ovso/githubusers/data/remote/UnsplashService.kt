package io.github.ovso.githubusers.data.remote

import io.github.ovso.githubusers.BuildConfig
import io.github.ovso.githubusers.data.remote.model.UnsplashResponse
import io.github.ovso.githubusers.data.remote.model.UnsplashSearchResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UnsplashService {
  @Headers(
    "Authorization: Client-ID 9_7SmsO0-DGH6oHXHrM-WUpWDXU92JKtsOG1lXzdyf0"
  )
  @GET("photos")
  suspend fun getPhotos(
    @Query("page") page: Int = 1
  ): List<UnsplashResponse>

  @GET("search/photos")
  suspend fun searchPhotos(
    @Query("query") query: String,
    @Query("page") page: Int,
    @Query("per_page") perPage: Int,
    @Query("client_id") clientId: String = "9_7SmsO0-DGH6oHXHrM-WUpWDXU92JKtsOG1lXzdyf0"
  ): UnsplashSearchResponse

  companion object {
    private const val BASE_URL = "https://api.unsplash.com/"

    fun create(): UnsplashService {
      val logger = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BASIC
      }

      val client = OkHttpClient.Builder()
        .addInterceptor(logger)
        .build()

      return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(UnsplashService::class.java)
    }
  }
}
