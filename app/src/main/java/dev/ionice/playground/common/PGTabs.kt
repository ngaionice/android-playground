package dev.ionice.playground.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

val TABS = listOf(Pair("Coil", Icons.Default.AccountBox), Pair("Location", Icons.Default.Place))

@Composable
fun PGTabRow(selectedIndex: Int, setSelectedIndex: (Int) -> Unit) {
    TabRow(selectedTabIndex = selectedIndex) {
        TABS.forEachIndexed { index, contents ->
            LeadingIconTab(
                selected = selectedIndex == index,
                onClick = { setSelectedIndex(index) },
                text = { Text(contents.first) },
                icon = { Icon(imageVector = contents.second, contentDescription = null) }
            )
        }
    }
}