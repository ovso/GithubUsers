package io.github.ovso.githubusers

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Test

class UnitTest {

  @Test
  fun test() = runBlocking {
    flow {
      emit(1)
      delay(3000)
      emit(2)
    }.collectLatest { value ->
      println("Collecting $value")
      delay(100) // Emulate work
      println("$value collected")
    }
  }
}
