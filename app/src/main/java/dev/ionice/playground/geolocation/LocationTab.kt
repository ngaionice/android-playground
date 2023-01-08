package dev.ionice.playground.geolocation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun LocationTab() {
    var location by remember { mutableStateOf<Coordinates?>(null) }
    var name by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LocationAccessor(onLocationAccess = { location = it })
        if (location != null) {
            Column {
                Text(text = "Latitude: ${location!!.lat}")
                Text(text = "Longitude: ${location!!.lon}")
            }
        }
        Text(text = name)
    }

    LaunchedEffect(key1 = location) {
        name = location?.let { getCityName(it) } ?: ""
    }
}