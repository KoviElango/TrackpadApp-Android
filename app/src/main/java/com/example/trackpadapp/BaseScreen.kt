package com.example.trackpadapp

import UDPManager
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun trackpadInterface(udpManager: UDPManager) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(1.dp)
            .background(Color.Black),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ){
                Trackpad(udpManager)
            }

            Box(
                modifier = Modifier
                    .weight(0.12f)
                    .background(Color.White)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ){
                ScrollBar(udpManager)
            }

        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { udpManager.sendCommand("click", "10.0.0.125", 6060) },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "L-Click")
            }

            Button(onClick = { udpManager.sendCommand("right_click", "10.0.0.125", 6060) },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "R-Click")
            }
        }
    }
}

