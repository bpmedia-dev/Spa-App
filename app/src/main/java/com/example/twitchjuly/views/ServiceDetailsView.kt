package com.example.twitchjuly.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.twitchjuly.model.AppointmentModel
import com.example.twitchjuly.model.ServiceModel
import com.example.twitchjuly.ui.theme.TwitchJulyTheme

@Composable
fun ServiceDetailsScreen(services: List<ServiceModel>, serviceId: Int, appointments: List<AppointmentModel>) {
    val service = services[serviceId]
    Column {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            text = service.serviceDescription,
            textAlign = TextAlign.Center
        )
        LazyColumn(
            modifier = Modifier
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(appointments) { appointment ->
                AppointmentViewHolder(
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(100.dp)
                        .padding(10.dp)
                        .clickable {
                           //TODO: add to user appoints
                        },
                    appointment = appointment)
            }
        }
    }
}

// We know this works so leave it be
/*
@Preview(showBackground = true)
@Composable
fun ServiceDetailsPreview() {
    val service = ServiceModel(
        serviceName = "Get the Money",
        serviceDescription = "Rule numba 1",
        isPopular = true,
        isAvailable = true
    )
    val appointments = listOf(
        AppointmentModel(
            serviceLocation = "Nashville",
            serviceAddress = "123 Broadway Ave, Nashville, TN 12345",
            serviceDate = "17.8.21",
            serviceTime = "6:30 CST",
            interval = "25",
            isPast = false
        ),
        AppointmentModel(
            serviceLocation = "Nashville",
            serviceAddress = "123 Broadway Ave, Nashville, TN 12345",
            serviceDate = "18.8.21",
            serviceTime = "6:30 CST",
            interval = "25",
            isPast = false
        ),
        AppointmentModel(
            serviceLocation = "Nashville",
            serviceAddress = "123 Broadway Ave, Nashville, TN 12345",
            serviceDate = "19.8.21",
            serviceTime = "6:30 CST",
            interval = "25",
            isPast = false
        )
    )
    TwitchJulyTheme {
        ServiceDetailsScreen(service, 0, appointments)
    }
}
*/