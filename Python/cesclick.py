import pyautogui
import time

# List of click positions
positions = [
    (952, 357),
    (957, 379),
    (954, 434),
    (955, 490),
    (957, 563),
    (957, 611),
    (958, 665),
    (1292, 820)
]

# Set the time interval between each click in seconds
interval = 2

# Loop through each position and click
for pos in positions:
    x, y = pos
    print(f"Mouse clicked at ({x}, {y})")
    pyautogui.click(x=x, y=y)
    time.sleep(interval)

print("All clicks completed.")
