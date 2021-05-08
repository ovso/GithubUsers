package io.github.ovso.githubusers.data.remote.model

import com.google.gson.annotations.SerializedName

data class UnsplashPhoto(
  @SerializedName("id") val id: String,
  @SerializedName("urls") val urls: UnsplashPhotoUrls,
  @SerializedName("user") val user: UnsplashUser
)

data class UnsplashPhotoUrls(
  @SerializedName("small") val small: String
)

data class UnsplashUser(
  @SerializedName("name") val name: String,
  @SerializedName("username") val username: String
) {
  val attributionUrl: String
    get() {
      return "https://unsplash.com/$username?utm_source=sunflower&utm_medium=referral"
    }
}

data class UnsplashSearchResponse(
  @SerializedName("results") val results: List<UnsplashPhoto>,
  @SerializedName("total_pages") val totalPages: Int

)
