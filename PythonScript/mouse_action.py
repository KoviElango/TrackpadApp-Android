from pynput.mouse import Controller, Button

# Mouse controller object
mouse = Controller()

# Move mouse by delta values (x and y)
def mouse_movement(delta_x, delta_y):
    current_x, current_y = mouse.position
    new_x, new_y = current_x + delta_x, current_y + delta_y
    mouse.position = (new_x, new_y)
    print(f"Mouse moved to: {mouse.position}")

# Process incoming commands, e.g., "move 10 20"
def process_command(command):
    print(f"Processing command: {command}")
    command_parts = command.split()
    action = command_parts[0]

    if action == "move":
        # Use float() to handle decimal values for mouse movement
        delta_x, delta_y = float(command_parts[1]), float(command_parts[2])
        mouse_movement(delta_x, delta_y)
        print(f"Mouse moved by ({delta_x}, {delta_y})")
    
    elif action == "click":
        mouse.press(Button.left)
        mouse.release(Button.left)
    
    elif action == "right_click":
        mouse.press(Button.right)
        mouse.release(Button.right)
    else:
        print(f"Unknown command: {action}")


