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

# Starting position for y-increment loop
x_start = 1183
y_start = 751
y_increment = 30  # Increment value for y
max_y = 820  # Maximum y value

# Set the time interval between each click in seconds
interval = 2

# Infinite loop with conditional stopping
while True:
        
    if y_start <= max_y:
        print(f"Mouse clicked at ({x_start}, {y_start})")
        pyautogui.click(x=x_start, y=y_start)
        time.sleep(interval)
        
        #Click through the fixed positions list first
        for pos in positions:
            x, y = pos
            print(f"Mouse clicked at ({x}, {y})")
            pyautogui.click(x=x, y=y)
            time.sleep(interval)
            
        y_start += y_increment  # Increment y by 30    

    print("All clicks completed. Restarting loop...")
    if y_start >= max_y:
        break
