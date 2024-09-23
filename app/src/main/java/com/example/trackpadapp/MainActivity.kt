package com.example.trackpadapp

import UDPManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge


class MainActivity : ComponentActivity() {
    private lateinit var udpManager: UDPManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        udpManager = UDPManager()
        setContent {
            TrackpadInterface(udpManager)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        udpManager.close()
    }
}

