import socket

def setup_server(host='0.0.0.0', port=5050):
    server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server_socket.bind((host, port))
    server_socket.listen(1)
    print(f"Server listening on {host}:{port}")
    return server_socket

def receive_data(server_socket):
    client_socket, client_address = server_socket.accept()
    print(f"Connected by {client_address}")
    while True:
        data = client_socket.recv(1024).decode()
        if not data:
            break
        print(f"Received command: {data}")
        yield data
    client_socket.close()