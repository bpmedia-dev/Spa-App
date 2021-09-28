package com.example.twitchjuly.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.twitchjuly.model.AppointmentModel
import com.example.twitchjuly.ui.theme.TwitchJulyTheme

@Composable
fun AppointmentViewHolder(modifier: Modifier, appointment: AppointmentModel) {
    val grey = Color(0xffd3d3d3) // TODO: This goes into colors file
    val red = Color(0xffffcccb) // TODO: This goes into colors file
    Card(
        modifier = modifier,
        backgroundColor = if (!appointment.isPast) grey else red,
        elevation = 5.dp,
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier.padding(start = 5.dp, end = 5.dp),
                    fontWeight = FontWeight.Bold,
                    text = "Location: ${appointment.serviceLocation}"
                )
                Text(
                    modifier = Modifier.padding(start = 5.dp, end = 5.dp),
                    text = appointment.serviceAddress
                )
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.padding(start = 5.dp, end = 5.dp),
                        text = "Time: ${appointment.serviceTime}"
                    )
                    Text(
                        modifier = Modifier.padding(start = 5.dp, end = 5.dp),
                        text = "Length: ${appointment.interval}"
                    )
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun AppointmentViewHolderPreview() {
    val appointment = AppointmentModel(
        serviceLocation = "Nashville",
        serviceAddress = "123 Broadway Ave, Nashville, TN 12345",
        serviceDate = "17.8.21",
        serviceTime = "6:30 CST",
        interval = "25",
        isPast = true
    )
    TwitchJulyTheme {
        AppointmentViewHolder(
            modifier = Modifier
                .fillMaxWidth()
                .size(100.dp)
                .padding(10.dp),
            appointment = appointment
        )
    }
}