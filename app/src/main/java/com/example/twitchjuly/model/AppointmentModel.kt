package com.example.twitchjuly.model

data class AppointmentModel(
    val serviceLocation: String,
    val serviceAddress: String,
    val serviceTime: String,
    val serviceDate: String,
    val interval: TimeSlots,
    val isPast: Boolean
)

enum class TimeSlots (val value: String) {
    THREEMINUTES("3"),
    THIRTYMINUTES("30"),
    SIXTYMINUTES("60")
}
