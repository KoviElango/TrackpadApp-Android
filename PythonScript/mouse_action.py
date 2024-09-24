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
        delta_x, delta_y = float(command_parts[1]), float(command_parts[2])
        mouse_movement(delta_x, delta_y)
        print(f"Mouse moved by ({delta_x}, {delta_y})")
    
    elif action == "click":
        mouse.press(Button.left)
        mouse.release(Button.left)
    
    elif action == "right_click":
        mouse.press(Button.right)
        mouse.release(Button.right)
    
    elif action == "scroll_up":
        mouse.scroll(0, -0.4)

    elif action == "scroll_down":
        mouse.scroll(0, 0.4)

     # Drag and drop logic
    elif action == "drag_start":
        # Initiates dragging (presses left mouse button down)
        mouse.press(Button.left)
        print("Drag started")

    elif action == "drag_move":
        # Moves the mouse while dragging
        delta_x, delta_y = float(command_parts[1]), float(command_parts[2])
        mouse_movement(delta_x, delta_y)
        print(f"Dragging mouse by ({delta_x}, {delta_y})")

    elif action == "drag_end":
        # Ends dragging (releases left mouse button)
        mouse.release(Button.left)
        print("Drag ended")
        
    else:
        print(f"Unknown command: {action}")


