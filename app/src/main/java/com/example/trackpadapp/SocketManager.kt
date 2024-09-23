package com.example.trackpadapp

import java.io.PrintWriter
import java.net.Socket
import kotlinx.coroutines.*

class SocketManager {
    private var socket: Socket? = null
    private var output: PrintWriter? = null

    fun connect() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                socket = Socket("10.0.0.125", 5050)
                output = PrintWriter(socket!!.getOutputStream(), true)
                println("Connected to server")
            }
            catch (e: Exception) {
                e.printStackTrace()
                println("Connection failed")
            }
        }
    }

    fun sendCommand(command: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                output?.println(command)
                println("Command sent: $command")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun close(){
        CoroutineScope(Dispatchers.IO).launch {
            try {
                output?.close()
                socket?.close()
            }
            catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}