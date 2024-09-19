def find_min_occurrence(numbers):
    counts = {}
    
    for num in numbers:
        if num in counts:
            counts[num] += 1
        else:
            counts[num] = 1
    
    min_occurrence = float('inf')
    min_number = None
    
    for num in numbers:
        if counts[num] < min_occurrence:
            min_occurrence = counts[num]
            min_number = num
    
    return min_number

def main():
    print("*** Minimum Occurrence ***")
    try:
        input_str = input("Enter some numbers: ").strip()
       
        numbers = list(map(int, input_str.split()))
       
        result = find_min_occurrence(numbers)
        
        print(result)
    
    except ValueError:
        print("Error: Please enter valid integers.")

main()
