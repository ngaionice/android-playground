package dev.ionice.playground.base

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PGTopAppBar(action: @Composable () -> Unit) {
    CenterAlignedTopAppBar(title = {
        Text(text = "Playground")
    }, actions = { action() })
}