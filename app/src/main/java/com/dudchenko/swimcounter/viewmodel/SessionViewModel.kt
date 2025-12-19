package com.dudchenko.swimcounter.viewmodel

import androidx.lifecycle.ViewModel
import com.dudchenko.swimcounter.model.SessionState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

import kotlin.math.max

class SessionViewModel : ViewModel() {

    private val _state = MutableStateFlow(SessionState())
    val state: StateFlow<SessionState> = _state

    private val distancePerCycle = 50

    fun addCycle() {
        update {
            it.copy(
                cycles = it.cycles + 1,
                totalDistance = it.totalDistance + distancePerCycle
            )
        }
    }

    fun removeCycle() {
        update {
            if (it.cycles > 0) {
                it.copy(
                    cycles = it.cycles - 1,
                    totalDistance = it.totalDistance - distancePerCycle
                )
            } else {
                it
            }
        }
    }

    fun addSet() {
        update { it.copy(sets = it.sets + 1, cycles = 0) }
    }

    fun removeSet() {
        update { it.copy(sets = max(0, it.sets - 1)) }
    }

    fun resetSession() {
        _state.value = SessionState()
    }

    private inline fun update(
        reducer: (SessionState) -> SessionState
    ) {
        _state.value = reducer(_state.value)
    }
}
