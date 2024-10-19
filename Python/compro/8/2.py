def rotateRight(message, n=1):
    n = n % len(message)  
    return message[-n:] + message[:-n]

print(" *** Rotate string ****")
message, n = input("Enter string / n : ").split('/')
n = int(n)
message = message.strip() 
print(f"New string => {rotateRight(message, n)}")
print("===== End of program =====")
