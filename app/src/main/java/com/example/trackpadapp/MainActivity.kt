package com.example.trackpadapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
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
    Box(
        modifier = Modifier
            .fillMaxSize()
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
        Text("Tap to control the mouse",
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        )
    }
}