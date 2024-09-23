from socket_handler import setup_server, receive_data
from mouse_action import move_mouse, left_click, right_click, scroll_up, drag_to

def process_command(command):
    command_parts = command.split()
    action = command_parts[0]

    if action == "move":
        x, y = int(command_parts[1]), int(command_parts[2])
        move_mouse(x, y)
        print(f"Mouse moved to ({x}, {y})")
    elif action == "click":
        left_click()
        print("Left click performed")
    elif action == "right_click":
        right_click()
        print("Right click performed")
    elif action == "scroll":
        amount = int(command_parts[1])
        scroll_up(amount)
        print(f"Scrolled up by {amount}")
    elif action == "drag":
        x, y = int(command_parts[1]), int(command_parts[2])
        drag_to(x, y)
        print(f"Mouse dragged to ({x}, {y})")
    else:
        print(f"Unknown command: {action}")

def main():
    # Set up the socket server
    server_socket = setup_server()

    # Loop to listen for incoming commands
    for command in receive_data(server_socket):
        process_command(command)

if __name__ == "__main__":
    main()
