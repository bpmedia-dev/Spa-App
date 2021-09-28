package com.example.twitchjuly.views

import android.view.Gravity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.twitchjuly.R
import com.example.twitchjuly.model.ServiceModel
import com.example.twitchjuly.ui.theme.TwitchJulyTheme

@Composable
fun ServiceViewHolder(modifier: Modifier, service: ServiceModel) {
    val Grey = Color(0xffd3d3d3)
    // TODO: How to make card clickable
    Card(
        modifier = modifier,
        backgroundColor = Grey,
        elevation = 5.dp,
        content = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(width = 150.dp, height = 150.dp),
                    contentScale = ContentScale.Fit,
                    painter = painterResource(R.drawable.ic_baseline_bathtub_24),
                    contentDescription = "a random tub"
                )
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = Modifier.padding(start = 5.dp, end = 5.dp),
                        fontWeight = FontWeight.Bold,
                        text = service.serviceName
                    )
                    Text(
                        modifier = Modifier.padding(start = 5.dp, end = 5.dp),
                        text = service.serviceDescription
                    )
                    Text(
                        modifier = Modifier.padding(start = 5.dp, end = 5.dp),
                        text = "Is service popular? ${service.isPopular}"
                    )
                }
            }
        }
    )
}

/*
Fancy stuff: If is available is false the card should dim the card
 */

@Preview(showBackground = true)
@Composable
fun ServiceViewHolderPreview() {
    val service = ServiceModel(
        serviceName = "Get the Money",
        serviceDescription = "Rule numba 1",
        isPopular = true,
        isAvailable = true
    )
    TwitchJulyTheme {
        ServiceViewHolder(
            modifier = Modifier
                .fillMaxWidth()
                .size(150.dp)
                .padding(10.dp),
            service = service)
    }
}