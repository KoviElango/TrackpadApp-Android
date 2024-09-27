package com.example.trackpadapp

import UDPManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrackpadInterface(udpManager: UDPManager) {
    val image1 = painterResource(R.drawable.background)
    var showMediaControl by remember { mutableStateOf(false) }
    var showKeyboardShortcuts by remember { mutableStateOf(false) }
    var showNetwork by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = image1,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(1.dp)
                .background(Color.DarkGray.copy(alpha = 0.2f)),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(8.dp)
                        .weight(0.12f),
                    verticalArrangement = Arrangement.Center
                ) {
                    Spacer(modifier = Modifier.weight(0.8f))

                    IconButton(
                        onClick = { showMediaControl = true },
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Circle,
                            contentDescription = "Media Control",
                            tint = Color(0xFF276972),
                            modifier = Modifier.size(48.dp)
                        )
                    }

                    IconButton(
                        onClick = { showKeyboardShortcuts = true },
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Circle,
                            contentDescription = "Keyboard Shortcuts Control",
                            tint = Color(0xFF276972),
                            modifier = Modifier.size(48.dp)
                        )
                    }
                    IconButton(
                        onClick = { showNetwork = true },
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Circle,
                            contentDescription = "Network Settings",
                            tint = Color(0xFF276972),
                            modifier = Modifier.size(48.dp)
                        )
                    }

                    Spacer(modifier = Modifier.weight(1.5f))
                }
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    contentAlignment = Alignment.Center
                ) {
                    Trackpad(udpManager)
                }

                Box(
                    modifier = Modifier
                        .weight(0.12f)
                        .background(Color(0xFFFF6F00).copy(alpha = 0.3f))
                        .fillMaxHeight(),
                    contentAlignment = Alignment.Center
                ) {
                    ScrollBar(udpManager)
                }

            }
            Surface(
                modifier = Modifier
                    .fillMaxWidth(),
                tonalElevation = 8.dp,
                color = MaterialTheme.colorScheme.surface.copy(alpha = 0.05f)
            ) {
                ButtonRow(udpManager)
            }
        }

        if (showMediaControl) {
            AlertDialog(
                onDismissRequest = { showMediaControl = false },
                content = { MediaControlToolbar(udpManager) },
            )
        }


        if (showKeyboardShortcuts) {
            AlertDialog(
                onDismissRequest = { showKeyboardShortcuts = false },
                content = { KeyboardShortcutsToolbar(udpManager) },
            )
    }
        if (showNetwork) {
            AlertDialog(
                onDismissRequest = { showNetwork = false },
                content = { NetworkSettings(udpManager) },
            )
        }


    }
}


