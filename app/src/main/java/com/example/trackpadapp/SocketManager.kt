import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress

//Refer to Doc: https://developer.android.com/reference/java/net/DatagramSocket

class UDPManager {
    private val socket = DatagramSocket()
    var serverIPinput = "10.0.0.125"

    fun setServerIP(ip: String) {
        serverIPinput = ip
    }

    // Use a coroutine to send the command asynchronously
    fun sendCommand(command: String) {

        val port = 6060
        // Use a coroutine to send the command asynchronously
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val address = InetAddress.getByName(serverIPinput)
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
