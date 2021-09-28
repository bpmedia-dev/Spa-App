package com.example.twitchjuly.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.twitchjuly.model.ServiceModel
import com.example.twitchjuly.ui.theme.TwitchJulyTheme

@Composable
fun ServicesScreen(navController: NavController, services: List<ServiceModel>) {
    // TODO: similar component to services
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        itemsIndexed(services) { index, service ->
            ServiceViewHolder(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(150.dp)
                    .padding(10.dp)
                    .clickable {
                        navController.navigate("details/$index")
                    },
                service = service)
        }
    }
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