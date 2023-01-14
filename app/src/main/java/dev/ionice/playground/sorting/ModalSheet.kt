package dev.ionice.playground.sorting

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun SheetScaffold(title: String, options: @Composable () -> Unit) {
    Column(modifier = Modifier.background(MaterialTheme.colorScheme.surfaceColorAtElevation(8.dp)).padding(bottom = 12.dp)) {
        Text(text = title, modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp), style = MaterialTheme.typography.labelLarge)
        Divider(modifier = Modifier.padding(bottom = 12.dp), color = MaterialTheme.colorScheme.surfaceVariant)
        options()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SheetItem(
    description: String,
    icon: ImageVector,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val containerColor =
        if (isSelected) MaterialTheme.colorScheme.secondaryContainer else Color.Transparent
    val contentColor =
        if (isSelected) MaterialTheme.colorScheme.onSecondaryContainer else ListItemDefaults.contentColor
    ListItem(
        leadingContent = { Icon(imageVector = icon, contentDescription = null) },
        headlineText = { Text(text = description) },
        modifier = Modifier.clickable { onClick() }
            .let { if (isSelected) it.clip(ActiveIndicatorShape) else it },
        colors = ListItemDefaults.colors(
            containerColor = containerColor,
            headlineColor = contentColor,
            leadingIconColor = contentColor
        ),
    )
}

private val ActiveIndicatorShape =
    RoundedCornerShape(
        topStart = CornerSize(0),
        topEnd = CornerSize(50),
        bottomEnd = CornerSize(50),
        bottomStart = CornerSize(0)
    )
