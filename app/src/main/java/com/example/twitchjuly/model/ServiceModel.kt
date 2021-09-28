package com.example.twitchjuly.model

data class ServiceModel (
    val serviceName: String,
    val serviceDescription: String,
    val isPopular: Boolean,
    val isAvailable: Boolean // TODO: use to determine clickability
    )