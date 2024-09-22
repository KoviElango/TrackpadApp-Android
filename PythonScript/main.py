from pynput.mouse import Controller, Button
mouse = Controller()

def moveTo(x,y):
    mouse.position = (x, y)

def click():
    pass

def dragTo():
    pass

def scroll():
    pass


def main():
    print('Enter position')
    x = int(input("X: "))
    y = int(input("Y: "))
    moveTo(x, y)
    print(f"Mouse moved to :({x},{y})")

if __name__ == "__main__":
    main()