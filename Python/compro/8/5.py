def printSquare(height, squareType):
    if squareType == 1:
        for i in range(height):
            if i == 0 or i == height - 1:
                print('*' * height)
            else:
                print('*' + ' ' * (height - 2) + '*')

    elif squareType == 2:
         for i in range(height):
            if i == 0:
                # First row: numbers decreasing from height-1 to 0
                for j in range(height, 0, -1):
                    print(j % 10, end='')
                print()
            elif i == height - 1:
                # Last row: numbers increasing from 1 to height
                for j in range(1, height + 1):
                    print(j % 10, end='')
                print()
            else:
                # Hollow part with numbers on both ends
                left_number = (height - i)%10
                right_number = (i % 10) + 1
                if right_number==10:
                    right_number = 0
                print(left_number, end='')  # Left side number
                print(' ' * (height - 2), end='')  # Spaces in the middle
                print(right_number)  # Right side number
    elif squareType == 3:
        for i in range(height):
            for j in range(height):
                print((min(j + 1, i + 1))%10, end='')
            print()


print(" *** Display square ***")
height, squareType = input("Enter height type : ").split()
height = int(height)
squareType = int(squareType)

printSquare(height, squareType)
print("===== End of program =====")
