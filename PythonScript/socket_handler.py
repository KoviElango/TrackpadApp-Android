import socket

def setup_udp_server(host='10.0.0.125', port=6060):
    # Create a UDP socket
    server_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    server_socket.bind((host, port))  # Bind to host and port
    print(f"UDP server listening on {host}:{port}")
    return server_socket

def receive_udp_data(server_socket):
    while True:
        try:
            # Receive data from client
            data, client_address = server_socket.recvfrom(1024)  # recvfrom() for UDP
            if not data:
                print("No data received, client may have disconnected.")
                break
            decoded_data = data.decode()
            print(f"Received command from {client_address}: {decoded_data}")
            yield decoded_data  # Yield the received data for processing
        except Exception as e:
            print(f"Error receiving data: {e}")
            break
