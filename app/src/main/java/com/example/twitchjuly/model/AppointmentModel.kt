package com.example.twitchjuly.model

data class AppointmentModel(
    val serviceLocation: String,
    val serviceAddress: String,
    val serviceTime: String,
    val serviceDate: String,
    val interval: String, // TODO: Def an enum
    val isPast: Boolean
)
