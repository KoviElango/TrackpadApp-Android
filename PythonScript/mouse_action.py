from pynput.mouse import Controller, Button

# Mouse controller object
mouse = Controller()
move_distance = 10

#all Basic mouse action function:
def mouse_movement(x,y):
    mouse.position = (x, y)

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