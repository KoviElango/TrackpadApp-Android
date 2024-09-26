package com.example.trackpadapp

import UDPManager
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Surface
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Fullscreen
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.icons.outlined.Replay
import androidx.compose.material.icons.outlined.SkipNext
import androidx.compose.material.icons.outlined.SkipPrevious
import androidx.compose.material.icons.outlined.VolumeDown
import androidx.compose.material.icons.outlined.VolumeOff
import androidx.compose.material.icons.outlined.VolumeUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MediaControlToolbar(udpManager: UDPManager) {
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
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // First Row of Icons
            Row(
                modifier = Modifier.padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                IconButton(onClick = { udpManager.sendCommand("fullscreen") }) {
                    Icon(
                        imageVector = Icons.Outlined.Fullscreen,
                        contentDescription = "Fullscreen",
                        modifier = Modifier.size(24.dp),
                        tint = Color.Black // Adjust color as necessary
                    )
                }
                IconButton(onClick = { udpManager.sendCommand("skip_previous") }) {
                    Icon(
                        imageVector = Icons.Outlined.SkipPrevious,
                        contentDescription = "Previous",
                        modifier = Modifier.size(24.dp),
                        tint = Color.Black
                    )
                }
                IconButton(onClick = { udpManager.sendCommand("pause_play") }) {
                    Icon(
                        imageVector = Icons.Outlined.PlayArrow,
                        contentDescription = "Play",
                        modifier = Modifier.size(24.dp),
                        tint = Color.Black
                    )
                }
                IconButton(onClick = { udpManager.sendCommand("skip_next") }) {
                    Icon(
                        imageVector = Icons.Outlined.SkipNext,
                        contentDescription = "Next",
                        modifier = Modifier.size(24.dp),
                        tint = Color.Black
                    )
                }
                IconButton(onClick = { udpManager.sendCommand("mute_unmute") }) {
                    Icon(
                        imageVector = Icons.Outlined.VolumeOff,
                        contentDescription = "Mute",
                        modifier = Modifier.size(24.dp),
                        tint = Color.Black
                    )
                }
            }

            // Second Row of Icons
            Row(
                modifier = Modifier.padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                IconButton(onClick = { udpManager.sendCommand("volume_down") }) {
                    Icon(
                        imageVector = Icons.Outlined.VolumeDown,
                        contentDescription = "Volume Down",
                        modifier = Modifier.size(24.dp),
                        tint = Color.Black
                    )
                }
                IconButton(onClick = { udpManager.sendCommand("volume_up") }) {
                    Icon(
                        imageVector = Icons.Outlined.VolumeUp,
                        contentDescription = "Volume Up",
                        modifier = Modifier.size(24.dp),
                        tint = Color.Black
                    )
                }
                IconButton(onClick = { udpManager.sendCommand("rewind") }) {
                    Icon(
                        imageVector = Icons.Outlined.Replay,
                        contentDescription = "Replay",
                        modifier = Modifier.size(24.dp),
                        tint = Color.Black
                    )
                }
            }
        }
    }
}
