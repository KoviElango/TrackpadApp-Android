package com.example.trackpadapp

import UDPManager
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

@Composable
fun ButtonRow(udpManager: UDPManager) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        val transparency = 0.4f
        Button(
            onClick = { udpManager.sendCommand("click", "10.0.0.125", 6060) },
            modifier = Modifier
                .weight(1f)
                .height(105.dp)
                .padding(5.dp),
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black.copy(alpha = transparency),
                contentColor = Color.White
            )
        ) {
            Text(text = "L")
        }

        Button(
            onClick = { udpManager.sendCommand("right_click", "10.0.0.125", 6060) },
            modifier = Modifier
                .weight(1f)
                .height(105.dp)
                .padding(5.dp),
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black.copy(alpha = transparency),
                contentColor = Color.White
            )
        ) {
            Text(text = "R")
        }
    }
}
