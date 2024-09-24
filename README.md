# Remote Trackpad App

## Overview
The **Remote Trackpad App** is an Android application designed to allow users to control their computer remotely via a trackpad interface. The app communicates with a server-side Python program that handles mouse movement and other commands using UDP. This project leverages Android Jetpack Compose for the UI and includes features such as media control, a virtual keyboard, and shortcuts.

The app primarily focuses on clean UI design. Many existing applications have cluttered interfaces and rely on a single mode of connection, which isn't efficient for all use cases. Although WebSockets provide faster full-duplex networking, we opt for a lighter and faster network method using **UDP**.

### UDP Communication
The app communicates with a Python-based UDP server to send real-time commands for mouse movements and clicks.

## Technology Stack

### Frontend:
- **Android (Kotlin, Jetpack Compose)**
- **Material 3 Design** for UI components

### Backend:
- **Python (UDP Server)**
- **Pynput Library** for mouse and keyboard control

## Project Structure

### Android App

**Main Files:**
- `TrackpadInterface.kt`: Contains the main UI for the trackpad interface and handles user interactions.
- `MediaControlPopup.kt`: Implements the media control popup using Jetpack Compose’s AlertDialog.
- `UDPManager.kt`: Manages the UDP communication between the Android app and the Python backend server.
- `MainActivity.kt`: Entry point for the Android app, initializing the UI and network components.

**UI Components:**
- **Trackpad**: Touch-sensitive area that tracks movement, detects drag and drop, single/double/triple taps, and sends corresponding commands to the server.
- **Media Control**: Includes play, pause, volume, and other media control functionalities in a popup window.
- **ScrollBar**: Handles vertical scrolling commands using a touch-based scroll bar.
- **Shortcut Panel (Upcoming)**: Quick system commands panel for operations like Alt-Tab and Ctrl+Alt+Delete.

### Dependencies:
- **Material 3 Components**
- **Jetpack Compose**
- **UDP Manager** for networking

### Python Backend

**Files:**
- `main.py`: Entry point for the UDP server. Listens for commands from the Android app and processes them.
- `mouse_action.py`: Contains functions for handling mouse movements, clicks, and drag-and-drop operations.
- `socket_handler.py`: Manages the UDP socket server that listens for incoming commands.

**Core Functionality:**
- **Mouse Movement**: The server processes incoming move commands to move the cursor.
- **Clicking**: Single-click, double-click, and right-click functionality.
- **Drag and Drop**: Handles drag operations triggered by a triple-tap on the Android app’s trackpad.
- **Scrolling**: Processes scroll_up and scroll_down commands to simulate scroll wheel behavior.

## Getting Started

### Prerequisites
- **Android Studio** (for Android development)
- **Python 3.10+**

### Install dependencies:
- **On Android**: No special setup required for dependencies beyond Android’s default setup.
- **On Python (server-side)**: Run `pip install pynput` and `pip install socket` for the necessary libraries.

### How to Run

#### Android App:

1. Clone the repository and open it in **Android Studio**.
2. Build and run the application on your device or emulator.

#### Python Server:

1. Navigate to the PythonScript folder and run:
    ```bash
    python main.py
    ```

### Trackpad Usage:

Once both the Android app and Python server are running, you can use the trackpad interface on the app to control your computer's mouse. Features like drag-and-drop and media control will also be accessible.

## Contributions

Feel free to fork this repository and submit pull requests for new features, improvements, or bug fixes. Suggestions and app improvements are very much welcomed!
