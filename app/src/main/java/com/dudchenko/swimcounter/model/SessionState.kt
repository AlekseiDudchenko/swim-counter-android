package com.dudchenko.swimcounter.model

data class SessionState(
    val distancePerCycle: Int = 0,
    val totalDistance: Int = 0,
    val cycles: Int = 0,
    val sets: Int = 0
) {
    val distanceMeters: Int
        get() = cycles * 50
}