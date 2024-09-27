package com.example.trackpadapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoGraph
import androidx.compose.material.icons.filled.Cached
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DesktopWindows
import androidx.compose.material.icons.filled.ZoomIn
import androidx.compose.material.icons.filled.ZoomOut
import androidx.compose.material.icons.filled.ZoomOutMap
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material.icons.outlined.ArrowForwardIos
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.DesktopWindows
import androidx.compose.material.icons.outlined.OpenInNew
import androidx.compose.material.icons.outlined.VolumeOff
import androidx.compose.material.icons.outlined.ZoomIn
import androidx.compose.material.icons.outlined.ZoomOut
import androidx.compose.material.icons.outlined.ZoomOutMap
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun KeyboardShortcutsToolbar() {
    // Implement the logic to display the keyboard shortcuts toolbar
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = MaterialTheme.shapes.medium,
        tonalElevation = 6.dp,
        color = Color(0xFFBBDEFB).copy(alpha = 0.5f)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {

//Essentials
            Text(text = "Essentials")
            Row(
                modifier = Modifier.padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                FloatingActionButton(onClick = { /* Todo */ }) {
                    Text("ESC")
                }
                FloatingActionButton(onClick = { /* Todo */ },
                ) {
                    Icon(
                        imageVector = Icons.Filled.AutoGraph,
                        contentDescription = "Task Manager"
                    )
                }
                FloatingActionButton(onClick = { /* Todo */ },
                ) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Close"
                    )
                }
                FloatingActionButton(onClick = { /* Todo */ },
                ) {
                    Icon(
                        imageVector = Icons.Filled.Cached,
                        contentDescription = "Refresh",
                    )
                }
                FloatingActionButton(onClick = { /* Todo */ },
                ) {
                    Icon(
                        imageVector = Icons.Outlined.DesktopWindows,
                        contentDescription = "Desktop",
                    )
                }
            }

//Zoom Control
            Text(text = "Zoom")

            Row(
                modifier = Modifier.padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                FloatingActionButton(
                    onClick = { /* Todo */ },
                ) {
                    Icon(
                        imageVector = Icons.Outlined.ZoomIn,
                        contentDescription = "Zoom in",
                    )
                }

                FloatingActionButton(
                    onClick = { /* Todo */ },
                ) {
                    Icon(
                        imageVector = Icons.Outlined.ZoomOut,
                        contentDescription = "Zoom Out",
                    )
                }

                FloatingActionButton(
                    onClick = { /* Todo */ },
                ) {
                    Icon(
                        imageVector = Icons.Outlined.ZoomOutMap,
                        contentDescription = "Full Screen",
                    )
                }
            }

//Chrome Shortcuts
            Text(text = "Browser Shortcuts")
            Row(
                modifier = Modifier.padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                FloatingActionButton(
                    onClick = { /* Todo */ },
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Add,
                        contentDescription = "",
                    )
                }
                FloatingActionButton(
                    onClick = { /* Todo */ },
                ) {
                    Icon(
                        imageVector = Icons.Outlined.ArrowBackIosNew,
                        contentDescription = "Previous Tab",
                    )
                }
                FloatingActionButton(
                    onClick = { /* Todo */ },
                ) {
                    Icon(
                        imageVector = Icons.Outlined.ArrowForwardIos,
                        contentDescription = "Next Tab",
                    )
                }
                FloatingActionButton(
                    onClick = { /* Todo */ },
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Close,
                        contentDescription = "Full Screen",
                    )
                }

                }

            Text(text = "Navigation")
            Row(
                modifier = Modifier.padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                ElevatedButton(onClick = { /* Todo */ }) {
                    Text("Ctrl + T")
                }
                ElevatedButton(onClick = { /* Todo */ }) {
                    Text("Ctrl + tab")
                }
                ElevatedButton(onClick = { /* Todo */ }) {
                    Text("Ctrl + J")
                }
            }
        }
    }
}

@Preview
@Composable
fun KeyboardShortcutsToolbarPreview() {
    KeyboardShortcutsToolbar()
}