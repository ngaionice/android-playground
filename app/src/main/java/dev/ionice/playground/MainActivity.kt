package dev.ionice.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Sort
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.ionice.playground.base.PGTabRow
import dev.ionice.playground.base.PGTopAppBar
import dev.ionice.playground.geolocation.LocationTab
import dev.ionice.playground.images.SquareImageCard
import dev.ionice.playground.images.unsplash.UnsplashApi
import dev.ionice.playground.sorting.SheetItem
import dev.ionice.playground.sorting.SheetScaffold
import dev.ionice.playground.sorting.SortingTab
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

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
private fun MainScreen() {
    var state by remember { mutableStateOf(0) }
    val scope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)

    Scaffold(topBar = {
        PGTopAppBar(action = {
            IconButton(onClick = {
                scope.launch {
                    sheetState.show()
                }
            }) {
                Icon(imageVector = Icons.Default.Sort, contentDescription = null, tint = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        })
    }) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            PGTabRow(selectedIndex = state, setSelectedIndex = { state = it })
            Box(Modifier.padding(16.dp)) {
                when (state) {
                    0 -> SquareImageCard(displayText = "Hoenn") {}
                    1 -> LocationTab()
                    2 -> SortingTab()
                }
            }
        }
    }
    ModalBottomSheetLayout(sheetContent = {
        SheetScaffold(title = "Sort by") {
            SheetItem(
                description = "Super",
                icon = Icons.Default.KeyboardArrowUp,
                isSelected = true,
                onClick = {})
            SheetItem(
                description = "Next",
                icon = Icons.Default.KeyboardArrowUp,
                isSelected = false,
                onClick = {})
        }
    }, sheetState = sheetState) {}

    LaunchedEffect(Unit) {
        scope.launch {
            println(UnsplashApi.service.searchImages("amazon"))
        }
    }
}