package io.github.ovso.githubusers.data.view

import io.github.ovso.githubusers.data.remote.model.Links
import io.github.ovso.githubusers.data.remote.model.Sponsorship
import io.github.ovso.githubusers.data.remote.model.Urls
import io.github.ovso.githubusers.data.remote.model.User

data class UnsplashItemModel(
  val altDescription: String?,
  val blurHash: String?,
  val categories: List<Any>?,
  val color: String?,
  val createdAt: String?,
  val currentUserCollections: List<Any>?,
  val description: Any??,
  val height: Int?,
  val id: String?,
  val likedByUser: Boolean?,
  val likes: Int?,
  val links: Links?,
  val promotedAt: Any?,
  val sponsorship: Sponsorship?,
  val updatedAt: String?,
  val urls: Urls?,
  val user: User?,
  val width: Int
)
