package com.dudchenko.swimcounter.model

private const val cycleLength = 50

data class TrainingState(
    // current set
    val setCycles: Int = 0,

    // current session
    val sessionSets: Int = 0,
    val sessionCycles: Int = 0,

    // whole training
    val trainingCycles: Int = 0
) {
    val setDistanceMeters: Int
        get() = setCycles * 50

    val sessionDistanceMeters: Int
        get() = sessionCycles * 50

    val trainingDistanceMeters: Int
        get() = trainingCycles * 50
}
