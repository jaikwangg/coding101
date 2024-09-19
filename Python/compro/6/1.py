def calculate_sum(numbers):
    total = 0
    for num in numbers:
        if num % 2 == 0:
            total += num  
        else:
            total -= num 
    return total

def main():
    print(" *** Sum even / Subtract odd ***")
    try:
        
        input_str = input("Enter numbers : ").strip()
        
        numbers = list(map(int, input_str.split()))
        
        if len(numbers) != 5:
            print("Sum is 0")
            return
        
        result = calculate_sum(numbers)
        
        print(f"Sum is {result}")
    
    except ValueError:
        print("Error: Please enter valid integers.")

main()
