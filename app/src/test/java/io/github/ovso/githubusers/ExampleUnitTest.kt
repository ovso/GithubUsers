package io.github.ovso.githubusers

import com.orhanobut.logger.Logger
import io.github.ovso.githubusers.data.remote.GithubService
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)

      runBlocking {
        val user = GithubService.create().getUsers()
        println("user: $user")
      }

    }
}
