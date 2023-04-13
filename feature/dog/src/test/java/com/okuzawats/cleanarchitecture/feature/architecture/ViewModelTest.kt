package com.okuzawats.cleanarchitecture.feature.architecture

import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest

import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ViewModelTest {

  private lateinit var target: ViewModel<Int, Int>

  @Before
  fun setUp() {
    target = object : ViewModel<Int, Int>() {
      override fun initialState(): Int = 0
    }
  }

  @After
  fun tearDown() {
  }

  @Test
  fun when_state_is_updated_it_observed() = runTest {
    target.state.test {
      target.onNewState(0)

      assertThat(awaitItem())
        .isEqualTo(0)

      target.onNewState(42)

      assertThat(awaitItem())
        .isEqualTo(42)
    }
  }

  @Test
  fun when_event_happen_it_observed() = runTest {
    target.event.test {
      target.onNewEvent(0)

      assertThat(awaitItem())
        .isEqualTo(0)

      target.onNewEvent(42)

      assertThat(awaitItem())
        .isEqualTo(42)
    }
  }
}
