def decode_shift_cipher(message, key):
    decoded_message = []
    
    for char in message:
        if 'a' <= char <= 'z':  
            shifted = (ord(char) - ord('a') - key) % 26
            decoded_message.append(chr(ord('a') + shifted))
        elif 'A' <= char <= 'Z':  
            shifted = (ord(char) - ord('A') - key) % 26
            decoded_message.append(chr(ord('A') + shifted))
        else:
            decoded_message.append(char)  
    return ''.join(decoded_message).upper()  

def main():
    print("Enter a word and a number:", end=' ')
    input_str = input().strip()
    try:
        if ' ' not in input_str:
            raise ValueError("Input must contain a space separating the message and the key.")
        
        message, key_str = input_str.rsplit(' ', 1)
        key = int(key_str)
        
        if not (1 <= key <= 26):
            print("Number must be between 1-26")
            return
        
        decoded_message = decode_shift_cipher(message, key)
        
        print(decoded_message)
    
    except ValueError as e:
        print(f"Error: {e}")

main()
