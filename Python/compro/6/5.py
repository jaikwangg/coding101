def process_numbers(numbers):
    odd_numbers = [num for num in numbers if num % 2 != 0]
    even_numbers = [num for num in numbers if num % 2 == 0]
    
    combined = odd_numbers + even_numbers
    
    new_list = odd_numbers[::-1] + even_numbers
    
    print(f"odd = {odd_numbers}")
    print(f"even = {even_numbers}")
    print(f"odd+even = {combined}")
    print(f"new = {new_list}")

def main():
    print(" *** Odd/Even at Left/Right ***")
    input_str = input("Enter numbers : ")
    numbers = list(map(int, input_str.split()))
    
    process_numbers(numbers)

main()
