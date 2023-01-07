package dev.ionice.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.ionice.playground.common.PGTabRow
import dev.ionice.playground.common.PGTopAppBar
import dev.ionice.playground.images.SquareImageCard
import dev.ionice.playground.images.unsplash.UnsplashApi
import dev.ionice.playground.ui.theme.PlaygroundTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaygroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MainScreen() {
    var state by remember { mutableStateOf(0) }
    val scope = rememberCoroutineScope()
    Scaffold(topBar = {
        PGTopAppBar()
    }) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            PGTabRow(selectedIndex = state, setSelectedIndex = { state = it })
            Box(Modifier.padding(16.dp)) {
                when (state) {
                    0 -> SquareImageCard(displayText = "Hoenn") {}
                }
            }
        }
    }
    LaunchedEffect(Unit) {
        scope.launch {
            println(UnsplashApi.service.searchImages("amazon"))
        }
    }
}