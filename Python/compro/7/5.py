def generate_numbers(sNum, index=0):
    if index == len(sNum):
        yield sNum
        return
    
    if sNum[index] in 'xy':
        for digit in '0123456789':
            new_sNum = sNum[:index] + digit + sNum[index+1:]
            yield from generate_numbers(new_sNum, index + 1)
    else:
        yield from generate_numbers(sNum, index + 1)

def find_divisible_numbers(sNum, divisor):
    results = []
    for num in generate_numbers(sNum):
        try:
            num_int = int(num)
            if num_int % divisor == 0:
                results.append(num_int)
        except ValueError:
            continue
    return results

def main():
    print(" *** Find divisible number ***")
    print("Enter sNum divisor : ", end="")
    input_str = input().strip()
    
    sNum, divisor = input_str.split()
    divisor = int(divisor)
    
    divisible_numbers = find_divisible_numbers(sNum, divisor)
    print(divisible_numbers)
    print("===== End of program =====")

main()
