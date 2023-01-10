package dev.ionice.playground.geolocation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.ionice.playground.geolocation.maps.MapDisplay

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
        if (location != null && name.isNotEmpty()) {
            MapDisplay(coordinates = location!!, name = name)
        }
    }

    LaunchedEffect(key1 = location) {
        name = location?.let { getCityName(it) } ?: ""
    }
}