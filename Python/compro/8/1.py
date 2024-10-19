def myNum(b):
    return int(b[::-1])

def mySum(a, b):
    return int(a) + myNum(b)

print(" *** My sum ***")
a, b = input("Enter a b : ").split()
print(f"{a} + {b} => {a} + {myNum(b)} = {mySum(a, b)}")
print("===== End of program =====")
