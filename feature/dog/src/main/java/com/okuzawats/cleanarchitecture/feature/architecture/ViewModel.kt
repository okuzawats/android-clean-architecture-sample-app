package com.okuzawats.cleanarchitecture.feature.architecture

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class ViewModel<STATE : Any, EVENT : Any> : androidx.lifecycle.ViewModel() {

    private val _state: MutableStateFlow<STATE> by lazy {
        MutableStateFlow(initialState())
    }

    val state: Flow<STATE> get() = _state.asStateFlow()

    private val _event: MutableSharedFlow<EVENT> by lazy {
        MutableSharedFlow()
    }

    val event: Flow<EVENT> get() = _event.asSharedFlow()

    abstract fun initialState(): STATE

    internal suspend fun onNewState(state: STATE) {
        _state.emit(state)
    }

    internal suspend fun onNewEvent(event: EVENT) {
        _event.emit(event)
    }
}
