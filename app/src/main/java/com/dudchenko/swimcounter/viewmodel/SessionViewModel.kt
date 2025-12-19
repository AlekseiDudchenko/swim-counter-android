package com.dudchenko.swimcounter.viewmodel

import androidx.lifecycle.ViewModel
import com.dudchenko.swimcounter.model.TrainingState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

import kotlin.math.max

class SessionViewModel : ViewModel() {

    private val _state = MutableStateFlow(TrainingState())
    val state: StateFlow<TrainingState> = _state

    fun addCycle() {
        update {
            it.copy(
                setCycles = it.setCycles + 1,
                sessionCycles = it.sessionCycles + 1,
                trainingCycles = it.trainingCycles + 1
            )
        }
    }

    fun removeCycle() {
        update {
            it.copy(
                setCycles = maxOf(0, it.setCycles - 1)
            )
        }
    }

    fun addSet() {
        update {
            it.copy(
                sessionSets = it.sessionSets + 1,
                setCycles = 0
            )
        }
    }

    fun removeSet() {
        update { it.copy(sessionSets = max(0, it.sessionSets - 1)) }
    }

    fun resetSession() {
        update {
            it.copy(
                setCycles = 0,
                sessionSets = 0,
                sessionCycles = 0
            )
        }
    }

    private inline fun update(
        reducer: (TrainingState) -> TrainingState
    ) {
        _state.value = reducer(_state.value)
    }
}
