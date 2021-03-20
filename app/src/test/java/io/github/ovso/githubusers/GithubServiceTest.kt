package io.github.ovso.githubusers

import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import io.github.ovso.githubusers.data.remote.GithubService
import io.github.ovso.githubusers.data.remote.MainRepository
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@HiltAndroidTest
class GithubServiceTest {

  @get:Rule
  val hiltRule = HiltAndroidRule(this)
  @Inject
  lateinit var repository: MainRepository

  @Test
  fun testRepository() {
    println(repository)
  }

  @Test
  fun githubService() {
    runBlocking {
      val user = GithubService.create().getUsers()
      println("user count: ${user.count()}")
    }
  }
}
