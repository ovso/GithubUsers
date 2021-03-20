package io.github.ovso.githubusers.data.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.github.ovso.githubusers.data.remote.model.UserResponse
import io.github.ovso.githubusers.data.remote.model.UserResponse2
import io.github.ovso.githubusers.data.remote.model.UserResponse3
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface GithubService {
  @GET("users")
  suspend fun getUsers(): List<UserResponse2>

  @GET("user")
  suspend fun getUser(): UserResponse

  companion object {
    private const val BASE_URL = "https://api.github.com/"

    fun create(): GithubService {
      val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

      val client = OkHttpClient.Builder()
        .addInterceptor(logger)
        .build()

      val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
      return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
//        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(GithubService::class.java)
    }
  }
}
