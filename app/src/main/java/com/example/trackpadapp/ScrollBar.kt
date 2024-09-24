package com.example.trackpadapp

import UDPManager
import android.view.MotionEvent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInteropFilter

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ScrollBar(udpManager: UDPManager) {
    var lastY = 0f // Track the last Y position

    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInteropFilter { event ->
                when (event.action) {
                    MotionEvent.ACTION_MOVE -> {
                        val deltaY = event.y - lastY // Calculate the difference between current and last Y position
                        lastY = event.y // Update the last Y position

                        // If deltaY is positive, it's a scroll down, otherwise it's a scroll up
                        if (deltaY < 0) {
                            udpManager.sendCommand("scroll_up", "10.0.0.125", 6060)
                        } else if (deltaY > 0) {
                            udpManager.sendCommand("scroll_down", "10.0.0.125", 6060)
                        }
                        true
                    }
                    MotionEvent.ACTION_DOWN -> {
                        // Set the initial Y position when touch is first detected
                        lastY = event.y
                        true
                    }
                    MotionEvent.ACTION_UP -> true // Stop scrolling when the user lifts their finger
                    else -> false
                }
            },
        contentAlignment = Alignment.Center
    ) {
    }
}