def remove_odd_characters(input_str):
    even_chars = [input_str[i] for i in range(len(input_str)) if (i + 1) % 2 == 0]
    
    result = ''.join(even_chars)
    
    return result

def main():
    print(" *** Remove ODD characters ***")
    input_str = input("Enter a string : ")
    
    even_characters = remove_odd_characters(input_str)
    
    print(f"Even characters = {even_characters}")

main()
