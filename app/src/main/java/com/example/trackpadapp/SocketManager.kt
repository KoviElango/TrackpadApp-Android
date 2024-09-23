import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress

class UDPManager {
    private val socket = DatagramSocket()

    // Use a coroutine to send the command asynchronously
    fun sendCommand(command: String, serverIP: String, port: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val address = InetAddress.getByName(serverIP)
                val data = command.toByteArray()
                val packet = DatagramPacket(data, data.size, address, port)
                socket.send(packet)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun close() {
        socket.close()
    }
}
