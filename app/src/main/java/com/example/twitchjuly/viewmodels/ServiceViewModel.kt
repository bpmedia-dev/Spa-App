package com.example.twitchjuly.viewmodels

import androidx.lifecycle.ViewModel
import com.example.twitchjuly.model.ServiceModel
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class ServiceViewModel : ViewModel() {
    private val serviceList = mutableListOf(
        ServiceModel(
            serviceName = "Get the Money",
            serviceDescription = "Rule numba 1",
            isPopular = true,
            isAvailable = true
        ),
        ServiceModel(
            serviceName = "Don't forget to get the Money",
            serviceDescription = "Rule numba 2",
            isPopular = true,
            isAvailable = true
        ),
        ServiceModel(
            serviceName = "Get Paid Lyrics",
            serviceDescription = "The Prophet",
            isPopular = true,
            isAvailable = true
        )
    )

    // TODO: pull details from server
    fun getServices() = serviceList
}