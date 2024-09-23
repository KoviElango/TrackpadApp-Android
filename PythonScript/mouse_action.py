from pynput.mouse import Controller, Button

# Mouse controller object
mouse = Controller()
move_distance = 10

#all Basic mouse action function:
def mouse_movement(delta_x, delta_y):
    current_x, current_y = mouse.position
    new_x, new_y = current_x + delta_x, current_y + delta_y
    mouse.position = (new_x, new_y)

def single_click():
    mouse.click(Button.left, 1)

def double_click():
    mouse.click(Button.left, 2)

def right_click():
    mouse.click(Button.right, 1)

def scrolling(amount):
     mouse.scroll(0, amount)

def drag_and_drop(x,y):
    mouse.press(Button.left)
    mouse.position = (x, y)
    mouse.release(Button.left)