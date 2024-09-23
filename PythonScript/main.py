from socket_handler import setup_udp_server, receive_udp_data
from mouse_action import process_command

def main():
    # Set up the UDP server
    server_socket = setup_udp_server()

    # Continuously listen for commands and process them
    for command in receive_udp_data(server_socket):
        process_command(command)

if __name__ == "__main__":
    main()
