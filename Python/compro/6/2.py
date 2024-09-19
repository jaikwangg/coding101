def check_sequence(numbers):
    if all(numbers[i] <= numbers[i + 1] for i in range(len(numbers) - 1)):
        return "Ascending sequence !!!"
    elif all(numbers[i] >= numbers[i + 1] for i in range(len(numbers) - 1)):
        return "Descending sequence !!!"
    else:
        return "Neither ascending or descending sequence !!!"


def main():
    print(" *** Sequence Verification ***")
    try:
        input_str = input("Enter Input : ").strip()
        
        numbers = list(map(int, input_str.split()))
        
        result = check_sequence(numbers)
        
        print(result)
    
    except ValueError:
        print("Error: Please enter valid integers.")

main()
