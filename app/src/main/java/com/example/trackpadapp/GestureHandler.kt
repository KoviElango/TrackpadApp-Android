package com.example.trackpadapp

import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput

@Composable
fun GestureControlledTrackpadWithScroll(socketManager: SocketManager) {
    Box(modifier = Modifier
        .fillMaxSize()
        .pointerInput(Unit) {
            detectTransformGestures { _, _, zoom, _ ->
                val command = if (zoom > 1) "scroll_up" else "scroll_down"
                socketManager.sendCommand(command)
            }
        }
    ) {
        Text("Swipe to scroll or zoom", modifier = Modifier.fillMaxSize())
    }
}