def find_max_value(numbers):
    return max(numbers)

def main():
    print(" *** Maximum value ***")
   
    input_str = input("Enter some numbers: ")
    
    numbers = [float(num) for num in input_str.split()]
    
    max_value = find_max_value(numbers)
    
    if max_value.is_integer():
            max_value = int(max_value)
    
    print(f"Max value = {max_value}")
    

main()
