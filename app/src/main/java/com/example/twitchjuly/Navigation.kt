package com.example.twitchjuly

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.twitchjuly.model.AppointmentModel
import com.example.twitchjuly.model.ServiceModel
import com.example.twitchjuly.model.TimeSlots
import com.example.twitchjuly.views.AppointmentsScreen
import com.example.twitchjuly.views.ServiceDetailsScreen
import com.example.twitchjuly.views.ServicesScreen

sealed class BottomNavigationScreens(val route: String, val label: String) {
    object Services : BottomNavigationScreens("services", "Services")
    object Appointments : BottomNavigationScreens("appointments", "Appointments")
    object ServiceDetails : BottomNavigationScreens("details/{serviceId}", "Service Details")
}

val bottomNavigationItems = listOf(
    BottomNavigationScreens.Services,
    BottomNavigationScreens.Appointments
)

@Composable
fun MainNavHost(navController: NavHostController) {
    val serviceList = mutableListOf(
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
    val appointments = listOf(
        AppointmentModel(
            serviceLocation = "Nashville",
            serviceAddress = "123 Broadway Ave, Nashville, TN 12345",
            serviceDate = "16.8.21",
            serviceTime = "6:30 CST",
            interval = TimeSlots.THIRTYMINUTES,
            isPast = true
        ),
        AppointmentModel(
            serviceLocation = "Nashville",
            serviceAddress = "123 Broadway Ave, Nashville, TN 12345",
            serviceDate = "18.8.21",
            serviceTime = "6:30 CST",
            interval = TimeSlots.THIRTYMINUTES,
            isPast = false
        ),
        AppointmentModel(
            serviceLocation = "Nashville",
            serviceAddress = "123 Broadway Ave, Nashville, TN 12345",
            serviceDate = "19.8.21",
            serviceTime = "6:30 CST",
            interval = TimeSlots.THIRTYMINUTES,
            isPast = false
        )
    )
    val userAppointments = listOf(
        AppointmentModel(
            serviceLocation = "Nashville",
            serviceAddress = "123 Broadway Ave, Nashville, TN 12345",
            serviceDate = "16.8.21",
            serviceTime = "6:30 CST",
            interval = TimeSlots.THIRTYMINUTES,
            isPast = true
        ),
        AppointmentModel(
            serviceLocation = "Nashville",
            serviceAddress = "123 Broadway Ave, Nashville, TN 12345",
            serviceDate = "19.8.21",
            serviceTime = "6:30 CST",
            interval = TimeSlots.THIRTYMINUTES,
            isPast = false
        ),
    )
    NavHost(
        navController = navController,
        startDestination = BottomNavigationScreens.Services.route
    ) {
        composable(BottomNavigationScreens.Services.route) { ServicesScreen(navController, services = serviceList) }
        composable(BottomNavigationScreens.Appointments.route) { AppointmentsScreen(userAppointments) }
        composable(
            BottomNavigationScreens.ServiceDetails.route,
            arguments = listOf(navArgument("serviceId") { type = NavType.IntType})
        ) { backStackEntry ->
            backStackEntry.arguments?.getInt("serviceId")?.let {
                ServiceDetailsScreen(
                    serviceList,
                    it,
                    appointments
                )
            }
        }
    }
}