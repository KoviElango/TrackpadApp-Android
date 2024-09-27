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

# Mouse click action
def click():
    mouse.press(Button.left)
    mouse.release(Button.left)
    print("Mouse clicked")

def right_click():
    mouse.press(Button.right)
    mouse.release(Button.right)
    print("Right-click performed")

def drag_start():
    mouse.press(Button.left)
    print("Drag started")

def drag_move(delta_x, delta_y):
    mouse_movement(delta_x, delta_y)
    print(f"Dragging mouse by ({delta_x}, {delta_y})")

def drag_end():
    mouse.release(Button.left)
    print("Drag ended")


def scroll_up():
    mouse.scroll(0, -0.4)
    print("Scrolled Up")

def scroll_down():
    mouse.scroll(0, 0.4)
    print("Scrolled Down")

# Media Player Action
def full_screen():
    keyboard.press(Key.F)
    keyboard.release(Key.F)
    print("F (Full Screen) pressed")

def volume_up():
    keyboard.press(Key.media_volume_up)
    keyboard.release(Key.media_volume_up)
    print("Volume Up")

def volume_down():
    keyboard.press(Key.media_volume_down)
    keyboard.release(Key.media_volume_down)
    print("Volume Down")

def mute():
    keyboard.press(Key.media_volume_mute)
    keyboard.release(Key.media_volume_mute)
    print("Mute/Unmute")

def pause_play():
    keyboard.press(Key.media_play_pause)
    keyboard.release(Key.media_play_pause)
    print("Pause/Play")

def next_track():
    keyboard.press(Key.media_next)
    keyboard.release(Key.media_next)
    print("Next Track")

def previous_track():
    keyboard.press(Key.media_previous)
    keyboard.release(Key.media_previous)
    print("Previous Track")

def rewind():
    keyboard.press(Key.alt)
    keyboard.press(Key.left)
    keyboard.release(Key.left)
    keyboard.release(Key.alt)
    print("Pressed Alt + Left Arrow")

# Keyboard shortcut functions
def esc():
    keyboard.press(Key.esc)
    keyboard.release(Key.esc)
    print("ESC pressed")

def task_manager():
    keyboard.press(Key.ctrl_l)
    keyboard.press(Key.shift)
    keyboard.press(Key.esc)
    keyboard.release(Key.ctrl_l)
    keyboard.release(Key.shift)
    keyboard.release(Key.esc)
    print("Task Manager opened")

def refresh_website():
    keyboard.press(Key.f5)
    keyboard.release(Key.f5)
    print("F5")

def alt_f4():
    keyboard.press(Key.alt_l)
    keyboard.press(Key.f4)
    keyboard.release(Key.alt_l)
    keyboard.release(Key.f4)
    print("Alt + F4")


def ctrl_0():
    keyboard.press(Key.ctrl)
    keyboard.press('0')
    keyboard.release(Key.ctrl)
    keyboard.release('0')
    print("Ctrl + 0")

def ctrl_plus():
    keyboard.press(Key.ctrl)
    keyboard.press('=')
    keyboard.release(Key.ctrl)
    keyboard.release('=')
    print("Ctrl + Plus")

def ctrl_minus():
    keyboard.press(Key.ctrl)
    keyboard.press('-')
    keyboard.release(Key.ctrl)
    keyboard.release('-')
    print("Ctrl + Minus")


def web_fullscreen():
    keyboard.press(Key.f11)
    keyboard.release(Key.f11)
    print("F11")

def ctrl_t():
    keyboard.press(Key.ctrl)
    keyboard.press('t')
    keyboard.release(Key.ctrl)
    keyboard.release('t')
    print("Ctrl + T (New Tab)")

def ctrl_w():
    keyboard.press(Key.ctrl)
    keyboard.press('w')
    keyboard.release(Key.ctrl)
    keyboard.release('w')
    print("Ctrl + W (Close Tab)")

def alt_tab():
    keyboard.press(Key.alt_l)
    keyboard.press(Key.tab)
    keyboard.release(Key.alt_l)
    keyboard.release(Key.tab)
    print("Alt + Tab")

def ctrl_h():
    keyboard.press(Key.ctrl)
    keyboard.press('h')
    keyboard.release(Key.ctrl)
    keyboard.release('h')
    print("Ctrl + H (History)")

    # 'Bookmark': lambda _: ctrl_shift_o(),


def ctrl_j():
    keyboard.press(Key.ctrl)
    keyboard.press('j')
    keyboard.release(Key.ctrl)
    keyboard.release('j')
    print("Ctrl + J (Downloads)")

def ctrl_shift_o():
    keyboard.press(Key.ctrl)
    keyboard.press(Key.shift)
    keyboard.press('o')
    keyboard.release(Key.ctrl)
    keyboard.release(Key.shift)
    keyboard.release('o')

def ctrl_k():
    keyboard.press(Key.ctrl)
    keyboard.press('k')
    keyboard.release(Key.ctrl)
    keyboard.release('k')
    print("Ctrl + K (Search/Address bar)")

def ctrl_page_up():
    keyboard.press(Key.ctrl)
    keyboard.press(Key.page_up)
    keyboard.release(Key.page_up)
    keyboard.release(Key.ctrl)
    print("Ctrl+PageUp pressed")

def ctrl_page_down():
    keyboard.press(Key.ctrl)
    keyboard.press(Key.page_down)
    keyboard.release(Key.page_down)
    keyboard.release(Key.ctrl)
    print("Ctrl+PageDown pressed")

def backspace():
    keyboard.press(Key.backspace)
    keyboard.release(Key.backspace)

def win_ctrl_v():
    with keyboard.pressed(Key.cmd):
        with keyboard.pressed(Key.ctrl):
            keyboard.press('v')
            keyboard.release('v')
    print("Windows + Ctrl + V pressed")

def win_d():
    with keyboard.pressed(Key.cmd):
        keyboard.press('d')
        keyboard.release('d')
    print("Windows + D")

# Command map
command_map = {
    'move': lambda args: mouse_movement(float(args[0]), float(args[1])),
    'click': lambda _: click(),
    'right_click': lambda _: right_click(),
    'drag_start': lambda _: drag_start(),
    'drag_move': lambda args: drag_move(float(args[0]), float(args[1])),
    'drag_end': lambda _: drag_end(),
    'scroll_up': lambda _: scroll_up(),
    'scroll_down': lambda _: scroll_down(),

    'fullscreen': lambda _:full_screen(),
    'volume_up': lambda _: volume_up(),
    'volume_down': lambda _: volume_down(),
    'mute_unmute': lambda _: mute(),
    'pause_play': lambda _: pause_play(),
    'next_track': lambda _: next_track(),
    'previous_track': lambda _: previous_track(),
    'rewind': lambda _: rewind(),

    'ESC': lambda _: esc(),
    'Task_Manager': lambda _: task_manager(),
    'Alt_F4': lambda _: alt_f4(),
    'F5': lambda _: refresh_website(),

    'Ctrl0':lambda _: ctrl_0(),
    'Ctrl+': lambda _: ctrl_plus(),
    'Ctrl-': lambda _: ctrl_minus(),
    'F11': lambda _:web_fullscreen(),

    'CtrlT': lambda _: ctrl_t(),
    'CtrlPageUp': lambda _: ctrl_page_up(),
    'CtrlPageDown': lambda _: ctrl_page_down(),
    'CtrlW': lambda _: ctrl_w(),

    'CtrlH': lambda _: ctrl_h(),
    'CtrlJ': lambda _: ctrl_j(),
    'Bookmark': lambda _: ctrl_shift_o(),
    'CtrlK': lambda _: ctrl_k(),

    'AltTab': lambda _: alt_tab(),
    'Backspace': lambda _: backspace(),
    'Sound_output': lambda _: win_ctrl_v(),
    'Desktop': lambda _: win_d(),
}

# Process incoming commands, e.g., "move 10 20"
def process_command(command):
    print(f"Processing command: {command}")
    command_parts = command.split()
    action = command_parts[0]
    args = command_parts[1:]

    if action in command_map:
        command_map[action](args)
    else:
        print(f"Unknown command: {action}")
