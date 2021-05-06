package io.github.ovso.githubusers.data.remote.model

import com.google.gson.annotations.SerializedName

data class UnsplashPhoto(
  @field:SerializedName("id") val id: String,
  @field:SerializedName("urls") val urls: UnsplashPhotoUrls,
  @field:SerializedName("user") val user: UnsplashUser
)

data class UnsplashPhotoUrls(
  @field:SerializedName("small") val small: String
)

data class UnsplashUser(
  @field:SerializedName("name") val name: String,
  @field:SerializedName("username") val username: String
) {
  val attributionUrl: String
    get() {
      return "https://unsplash.com/$username?utm_source=sunflower&utm_medium=referral"
    }
}

data class UnsplashSearchResponse(
  @field:SerializedName("results") val results: List<UnsplashPhoto>,
  @field:SerializedName("total_pages") val totalPages: Int

)
