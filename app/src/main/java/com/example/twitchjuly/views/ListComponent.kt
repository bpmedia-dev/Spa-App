package com.example.twitchjuly.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.twitchjuly.model.AppointmentModel
import com.example.twitchjuly.model.ServiceModel

@Composable
fun ListComponent(navController: NavController?, services: List<ServiceModel>, appointments: List<AppointmentModel>) {
    LazyColumn(
    modifier = Modifier
    .fillMaxSize()
    .padding(top = 5.dp),
    horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if(services.isNotEmpty()) {
            itemsIndexed(services) { index, service ->
                ServiceViewHolder(
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(150.dp)
                        .padding(10.dp)
                        .clickable {
                            navController?.navigate("details/$index")
                        },
                    service = service
                )
            }
        } else {
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
}