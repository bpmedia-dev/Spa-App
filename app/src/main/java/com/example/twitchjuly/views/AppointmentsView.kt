package com.example.twitchjuly.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.twitchjuly.model.AppointmentModel
import com.example.twitchjuly.ui.theme.TwitchJulyTheme

@Composable
fun AppointmentsScreen(appointments: List<AppointmentModel>) {
    // TODO: similar component to services
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(appointments) { appointment ->
            AppointmentViewHolder(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(100.dp)
                    .padding(10.dp),
                appointment = appointment
            )
        }
    }
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
            interval = "25",
            isPast = true
        ),
        AppointmentModel(
            serviceLocation = "Nashville",
            serviceAddress = "123 Broadway Ave, Nashville, TN 12345",
            serviceDate = "19.8.21",
            serviceTime = "6:30 CST",
            interval = "25",
            isPast = false
        ),
    )
    TwitchJulyTheme {
        AppointmentsScreen(userAppointments)
    }
}