def isPrime(n):
    if n <= 1:
        return False
    for i in range(2, int(n**0.5) + 1):
        if n % i == 0:
            return False
    return True


def showPrime(x, y):
    global count_prime  
    primes = []
    for num in range(min(x, y), max(x, y) + 1):
        if isPrime(num):
            primes.append(num)
            count_prime += 1
    return primes

count_prime = 0
print(" ***Prime from a to b ***")
m, n = input("Enter a b : ").split()
a = int(m)
b = int(n)

if a < 0 or b < 0:
    print("Both numbers must be positive !!!")
    print("===== End of program =====")
    quit()

ans = showPrime(a, b)
print(f"Prime number from {min(a,b)} to {max(a,b)} : ", end="")
for i in ans:
    print(i, end=" ")
print(f"\nTotal prime numbers = {count_prime}")
print("===== End of program =====")
