package com.example.twitchjuly.views

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.twitchjuly.ui.theme.TwitchJulyTheme

@Composable
fun DummyScreen() {
    Text("Dummy!")
}

@Preview(showBackground = true)
@Composable
fun DummyPreview() {
    TwitchJulyTheme {
        DummyScreen()
    }
}