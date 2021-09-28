package com.example.twitchjuly

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.twitchjuly.model.AppointmentModel
import com.example.twitchjuly.model.ServiceModel
import com.example.twitchjuly.model.TimeSlots
import com.example.twitchjuly.viewmodels.AppointmentViewModel
import com.example.twitchjuly.viewmodels.ServiceViewModel
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
    val serviceViewModel = hiltViewModel<ServiceViewModel>()
    val appointmentViewModel = hiltViewModel<AppointmentViewModel>()

    NavHost(
        navController = navController,
        startDestination = BottomNavigationScreens.Services.route
    ) {
        composable(BottomNavigationScreens.Services.route) { ServicesScreen(navController, services = serviceViewModel.getServices()) }
        composable(BottomNavigationScreens.Appointments.route) { AppointmentsScreen(appointmentViewModel.getUserAppointments()) }
        composable(
            BottomNavigationScreens.ServiceDetails.route,
            arguments = listOf(navArgument("serviceId") { type = NavType.IntType})
        ) { backStackEntry ->

            backStackEntry.arguments?.getInt("serviceId")?.let {
                ServiceDetailsScreen(
                    serviceViewModel.getServices(),
                    it,
                    appointmentViewModel.getAvailableAppointments()
                )
            }
        }
    }
}