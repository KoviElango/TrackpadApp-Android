package com.example.trackpadapp

import UDPManager
import android.os.Bundle
import android.view.MotionEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    private lateinit var udpManager: UDPManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        udpManager = UDPManager()
        setContent {
            Trackpad(udpManager)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        udpManager.close()
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Trackpad(udpManager: UDPManager) {
    val sensitivityFactor = 1.5f
    var lastX = 0f
    var lastY = 0f

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
                        udpManager.sendCommand("move $deltaX $deltaY", "10.0.0.125", 6060) // Replace with your server IP and port
                        true
                    }
                    MotionEvent.ACTION_DOWN -> {
                        lastX = event.x
                        lastY = event.y
                        true
                    }
                    MotionEvent.ACTION_UP -> true
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
