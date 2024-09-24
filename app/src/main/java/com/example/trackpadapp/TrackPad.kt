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

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Trackpad(udpManager: UDPManager) {
    val sensitivityFactor = 1.5f
    var lastX = 0f
    var lastY = 0f
    var hasMoved = false

    var tapCount = 0
    var lastTapTime = 0L
    var isDragging = false
    var isLocked = false

    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInteropFilter { event ->
                when (event.action) {
                    // Handle mouse movement when dragging is enabled
                    MotionEvent.ACTION_MOVE -> {
                        if (isDragging) {
                            val deltaX = (event.x - lastX) * sensitivityFactor
                            val deltaY = (event.y - lastY) * sensitivityFactor
                            udpManager.sendCommand("drag_move $deltaX $deltaY", "10.0.0.125", 6060)
                            lastX = event.x
                            lastY = event.y
                        } else {
                            val deltaX = (event.x - lastX) * sensitivityFactor
                            val deltaY = (event.y - lastY) * sensitivityFactor
                            lastX = event.x
                            lastY = event.y
                            hasMoved = true
                            udpManager.sendCommand("move $deltaX $deltaY", "10.0.0.125", 6060)
                        }
                        true
                    }

                    MotionEvent.ACTION_DOWN -> {
                        val currentTime = System.currentTimeMillis()

                        // Detect triple tap within 500ms
                        if (currentTime - lastTapTime < 500) {
                            tapCount++
                        } else {
                            tapCount = 1 // Reset tap count
                        }
                        lastTapTime = currentTime

                        if (tapCount == 3 && !isDragging) {
                            // Triple tap detected, initiate drag
                            isDragging = true
                            isLocked = true
                            udpManager.sendCommand("drag_start", "10.0.0.125", 6060)
                            tapCount = 0 // Reset the tap count after drag start
                        } else if (isDragging) {
                            // Handle tap to drop the dragged item
                            udpManager.sendCommand("end_drag", "10.0.0.125", 6060)
                            isLocked = false
                            isDragging = false
                        }

                        lastX = event.x
                        lastY = event.y
                        hasMoved = false
                        true
                    }

                    MotionEvent.ACTION_UP -> {
                        // Handle regular click if no movement has happened
                        if (!hasMoved && !isDragging) {
                            udpManager.sendCommand("click", "10.0.0.125", 6060)
                        }
                        true
                    }

                    else -> false
                }
            }
    ) {
        Text(
            text = "Use the trackpad to move the mouse or drag with triple tap.",
            modifier = Modifier.padding(16.dp)
        )
    }
}

