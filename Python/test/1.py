rows = int(input("Enter the number of rows: "))

for i in range(1, rows + 1):
    for space in range(1, rows - i + 1):
        print(" ", end=' ')
    
    k = 0
    while k != 2 * i - 1:
        print("*", end='')
        k += 1
    
    print()
