from pynput.mouse import Controller as MouseController, Button
from pynput.keyboard import Controller as KeyboardController, Key

# Mouse and keyboard controller objects
mouse = MouseController()
keyboard = KeyboardController()

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
        mouse.press(Button.left)
        print("Drag started")

    elif action == "drag_move":
        delta_x, delta_y = float(command_parts[1]), float(command_parts[2])
        mouse_movement(delta_x, delta_y)
        print(f"Dragging mouse by ({delta_x}, {delta_y})")

    elif action == "drag_end":
        mouse.release(Button.left)
        print("Drag ended")

    # Media control commands
    elif action == "volume_up":
        keyboard.press(Key.media_volume_up)
        keyboard.release(Key.media_volume_up)
        print("Volume increased")

    elif action == "volume_down":
        keyboard.press(Key.media_volume_down)
        keyboard.release(Key.media_volume_down)
        print("Volume decreased")

    elif action == "mute_unmute":
        keyboard.press(Key.media_volume_mute)
        keyboard.release(Key.media_volume_mute)
        print("Mute/unmute toggled")

    elif action == "pause_play":
        keyboard.press(Key.media_play_pause)
        keyboard.release(Key.media_play_pause)
        print("Play/Pause toggled")

    # Specific keyboard keys
    elif action == "fullscreen":
        keyboard.press('f')
        keyboard.release('f')
        print("Pressed 'F'")

    elif action == "skip_next":
        keyboard.press(Key.right)
        keyboard.release(Key.right)
        print("Pressed Right Arrow")

    elif action == "skip_previous":
        keyboard.press(Key.left)
        keyboard.release(Key.left)
        print("Pressed Left Arrow")

    elif action == "rewind":
        keyboard.press(Key.alt)
        keyboard.press(Key.left)
        keyboard.release(Key.left)
        keyboard.release(Key.alt)
        print("Pressed Alt + Left Arrow")

    else:
        print(f"Unknown command: {action}")
