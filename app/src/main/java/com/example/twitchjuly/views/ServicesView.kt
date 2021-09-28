package com.example.twitchjuly.views

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.twitchjuly.model.ServiceModel

@Composable
fun ServicesScreen(navController: NavController, services: List<ServiceModel>) {
    ListComponent(navController = navController, services = services, appointments = emptyList())
}

//No preview because of navController
/*
@Preview(showBackground = true)
@Composable
fun ServicePreview() {
    val services = mutableListOf(
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
    TwitchJulyTheme {
        ServicesScreen(
            services = services)
    }
}
*/