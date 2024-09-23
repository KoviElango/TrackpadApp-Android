import socket

def setup_server(host='10.0.0.125', port=5050):
    server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server_socket.bind((host, port))
    server_socket.listen(1)
    print(f"Server listening on {host}:{port}")
    return server_socket

def receive_data(server_socket):
    client_socket, client_address = server_socket.accept()
    print(f"Waiting for data from {client_address}...")  # Accepts incoming connection
    print(f"Connected by {client_address}")
    while True:
        try:
            data = client_socket.recv(1024).decode()
            if not data:
                print("Client disconnected.")
                break
            print(f"Received command: {data}")
            yield data  # Yield the command for processing
        except Exception as e:
            print(f"Error receiving data: {e}")
            break
    client_socket.close()
