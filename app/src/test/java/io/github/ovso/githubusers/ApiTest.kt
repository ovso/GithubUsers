package io.github.ovso.githubusers

import io.github.ovso.githubusers.data.remote.GithubService
import io.github.ovso.githubusers.data.remote.MainRepositoryImpl
import io.github.ovso.githubusers.data.remote.UnsplashService
import kotlinx.coroutines.runBlocking
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ApiTest {

  @Test
  fun mainRepository() {
    val repo = MainRepositoryImpl(GithubService.create(), UnsplashService.create())
    runBlocking {
      val photos = repo.getPhotos(1)
      println("thumb: ${photos.first().urls.thumb}")
    }
  }
}
