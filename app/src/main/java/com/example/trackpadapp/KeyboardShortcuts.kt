package com.example.trackpadapp

import UDPManager
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
import androidx.compose.material.icons.filled.Backspace
import androidx.compose.material.icons.filled.Cached
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DesktopWindows
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.SurroundSound
import androidx.compose.material.icons.filled.SyncAlt
import androidx.compose.material.icons.filled.Web
import androidx.compose.material.icons.filled.ZoomIn
import androidx.compose.material.icons.filled.ZoomOut
import androidx.compose.material.icons.filled.ZoomOutMap
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material.icons.outlined.ArrowForwardIos
import androidx.compose.material.icons.outlined.Backspace
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.DesktopWindows
import androidx.compose.material.icons.outlined.Download
import androidx.compose.material.icons.outlined.FitScreen
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.OpenInNew
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.outlined.SurroundSound
import androidx.compose.material.icons.outlined.VolumeOff
import androidx.compose.material.icons.outlined.Web
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
fun KeyboardShortcutsToolbar(udpManager: UDPManager) {
    // Implement the logic to display the keyboard shortcuts toolbar
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        shape = MaterialTheme.shapes.medium,
        tonalElevation = 6.dp,
        color = Color(0xFFBBDEFB).copy(alpha = 0.8f)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

//Essentials
            Text(text = "Essentials")
            Spacer(modifier = Modifier.size(8.dp))
            Row(
                modifier = Modifier.padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                FloatingActionButton(onClick = { udpManager.sendCommand("ESC") }) {
                    Text("ESC")
                }
                FloatingActionButton(onClick = { udpManager.sendCommand("Task_Manager") },
                ) {
                    Icon(
                        imageVector = Icons.Filled.AutoGraph,
                        contentDescription = "Task Manager"
                    )
                }
                FloatingActionButton(onClick = { udpManager.sendCommand("Alt_F4") },
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Cancel,
                        contentDescription = "Close"
                    )
                }
                FloatingActionButton(onClick = { udpManager.sendCommand("F5") },
                ) {
                    Icon(
                        imageVector = Icons.Filled.Cached,
                        contentDescription = "Refresh",
                    )
                }
            }

//Zoom Control
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "Zoom")
            Spacer(modifier = Modifier.size(8.dp))

            Row(
                modifier = Modifier.padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                FloatingActionButton(
                    onClick = { udpManager.sendCommand("Ctrl0") },
                ) {
                    Icon(
                        imageVector = Icons.Outlined.FitScreen,
                        contentDescription = "Fit Screen",
                    )
                }
                FloatingActionButton(
                    onClick = { udpManager.sendCommand("Ctrl+") },
                ) {
                    Icon(
                        imageVector = Icons.Outlined.ZoomIn,
                        contentDescription = "Zoom in",
                    )
                }

                FloatingActionButton(
                    onClick = { udpManager.sendCommand("Ctrl-") },
                ) {
                    Icon(
                        imageVector = Icons.Outlined.ZoomOut,
                        contentDescription = "Zoom Out",
                    )
                }

                FloatingActionButton(
                    onClick = { udpManager.sendCommand("F11") },
                ) {
                    Icon(
                        imageVector = Icons.Outlined.ZoomOutMap,
                        contentDescription = "Full Screen",
                    )
                }
            }

//Chrome Shortcuts
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "Chrome Shortcuts")
            Spacer(modifier = Modifier.size(8.dp))

            Row(
                modifier = Modifier.padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                FloatingActionButton(
                    onClick = { udpManager.sendCommand("CtrlT") },
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Add,
                        contentDescription = "New Tab",
                    )
                }
                FloatingActionButton(
                    onClick = { udpManager.sendCommand("CtrlPageUp") },
                ) {
                    Icon(
                        imageVector = Icons.Outlined.ArrowBackIosNew,
                        contentDescription = "Previous Tab",
                    )
                }
                FloatingActionButton(
                    onClick = {udpManager.sendCommand("CtrlPageDown") },
                ) {
                    Icon(
                        imageVector = Icons.Outlined.ArrowForwardIos,
                        contentDescription = "Next Tab",
                    )
                }
                FloatingActionButton(
                    onClick = { udpManager.sendCommand("CtrlW") },
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Close,
                        contentDescription = "Close Tab",
                    )
                }
            }
            Row(
                modifier = Modifier.padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                FloatingActionButton(
                    onClick = { udpManager.sendCommand("CtrlH") },
                ) {
                    Icon(
                        imageVector = Icons.Outlined.History,
                        contentDescription = "History",
                    )
                }
                FloatingActionButton(
                    onClick = { udpManager.sendCommand("CtrlJ") },
                ) {
                    Icon(
                        imageVector = Icons.Filled.Download,
                        contentDescription = "Downloads",
                    )
                }
                FloatingActionButton(
                    onClick = { udpManager.sendCommand("Bookmark") },
                ) {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "BookMark",
                    )

                }
                FloatingActionButton(
                    onClick = { udpManager.sendCommand("CtrlK") },
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Web,
                        contentDescription = "AddressBar",
                    )

                }
            }

//Windows Shortcuts
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "Windows Shortcuts")
            Spacer(modifier = Modifier.size(8.dp))

            Row(
                modifier = Modifier.padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                FloatingActionButton(
                    onClick = { udpManager.sendCommand("AltTab") },
                ) {
                    Icon(
                        imageVector = Icons.Filled.SyncAlt,
                        contentDescription = "Alt Tab",
                    )

                }
                FloatingActionButton(
                    onClick = { udpManager.sendCommand("Backspace") },
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Backspace,
                        contentDescription = "Backspace",
                    )

                }
                FloatingActionButton(
                    onClick = { udpManager.sendCommand("Sound_output") },
                ) {
                    Icon(
                        imageVector = Icons.Outlined.SurroundSound,
                        contentDescription = "Sound Output",
                    )

                }
                FloatingActionButton(onClick = { udpManager.sendCommand("Desktop") },
                ) {
                    Icon(
                        imageVector = Icons.Outlined.DesktopWindows,
                        contentDescription = "Desktop",
                    )
                }
            }
        }
    }
}