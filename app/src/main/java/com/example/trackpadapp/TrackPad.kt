package com.example.trackpadapp

import android.view.MotionEvent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.unit.dp
import UDPManager


//This piece leverages MotionEvents: https://developer.android.com/reference/android/view/MotionEvent
//ACTION_MOVE - Constant for getActionMasked(): A change has happened during a press gesture (between ACTION_DOWN and ACTION_UP).

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Trackpad(udpManager: UDPManager) {
    val sensitivityFactor = 1.5f
    var lastX = 0f
    var lastY = 0f
    var hasMoved = false

    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInteropFilter { event ->
                when (event.action) {
                    MotionEvent.ACTION_MOVE -> {
                        val deltaX = (event.x - lastX) * sensitivityFactor
                        val deltaY = (event.y - lastY) * sensitivityFactor
                        lastX = event.x
                        lastY = event.y
                        hasMoved = true
                        udpManager.sendCommand("move $deltaX $deltaY", "10.0.0.125", 6060) // Replace with your server IP and port
                        true
                    }
                    MotionEvent.ACTION_DOWN -> {
                        hasMoved = false
                        lastX = event.x
                        lastY = event.y
                        true
                    }
                    MotionEvent.ACTION_UP -> {
                        if (!hasMoved) {
                            udpManager.sendCommand("click", "10.0.0.125", 6060)
                        }
                        true
                    }
                    else -> false
                }
            }
    ) {
        Text(
            text = "Use the trackpad to move the mouse.",
            modifier = Modifier.padding(16.dp)
        )
    }
}