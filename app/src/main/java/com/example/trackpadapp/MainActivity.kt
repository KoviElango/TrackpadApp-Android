package com.example.trackpadapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import com.example.trackpadapp.ui.theme.TrackpadAppTheme

class MainActivity : ComponentActivity() {
    private lateinit var socketManager: SocketManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        socketManager = SocketManager()
        socketManager.connect()
        setContent {
            TrackpadAppTheme {
                Trackpad(socketManager)
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        socketManager.close()
    }
}

@Composable
fun Trackpad(socketManager: SocketManager) {
    val sensitivityFactor = 3.0f // Increase this for more sensitivity

    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectDragGestures(
                    onDrag = { change, dragAmount ->
                        change.consume()
                        val (deltaX, deltaY) = dragAmount

                        // Amplify the delta values for smoother and more sensitive movement
                        val adjustedDeltaX = (deltaX * sensitivityFactor).toInt()
                        val adjustedDeltaY = (deltaY * sensitivityFactor).toInt()

                        socketManager.sendCommand("move $adjustedDeltaX $adjustedDeltaY")
                    },
                    onDragStart = { offset ->
                        println("Drag started at $offset")
                    },
                    onDragEnd = {
                        println("Drag ended")
                    },
                    onDragCancel = {
                        println("Drag cancelled")
                    }
                )
            }
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        socketManager.sendCommand("click") // Send left-click command
                    },
                    onLongPress = {
                        socketManager.sendCommand("right_click") // Send right-click command
                    },
                    onDoubleTap = {
                        socketManager.sendCommand("double_click") // Send double-click command
                    }
                )
            }
    ) {
        Text("Use drag to move the mouse. Tap for click.",
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        )
    }
}

