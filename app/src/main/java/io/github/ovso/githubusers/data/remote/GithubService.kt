package io.github.ovso.githubusers.data.remote

import io.github.ovso.githubusers.data.remote.model.UserResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface GithubService {
  @GET("users")
  suspend fun getUsers(): List<UserResponse>

  @GET("user")
  suspend fun getUser(): UserResponse

  companion object {
    private const val BASE_URL = "https://api.github.com/"

    fun create(): GithubService {
      val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

      val client = OkHttpClient.Builder()
        .addInterceptor(logger)
        .build()

      return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(GithubService::class.java)
    }
  }
}
