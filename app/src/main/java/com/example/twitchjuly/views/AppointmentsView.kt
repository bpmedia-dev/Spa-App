package com.example.twitchjuly.views

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.twitchjuly.model.AppointmentModel
import com.example.twitchjuly.model.TimeSlots
import com.example.twitchjuly.ui.theme.TwitchJulyTheme

@Composable
fun AppointmentsScreen(appointments: List<AppointmentModel>) {
    ListComponent(navController = null, services = emptyList(), appointments = appointments)
}

@Preview(showBackground = true)
@Composable
fun AppointmentsPreview() {
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
    TwitchJulyTheme {
        AppointmentsScreen(userAppointments)
    }
}