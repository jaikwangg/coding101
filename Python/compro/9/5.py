# ADFGX cipher key dictionary
cipher_key = {
    ('A', 'A'): 'b', ('A', 'D'): 't', ('A', 'F'): 'a', ('A', 'G'): 'l', ('A', 'X'): 'p',
    ('D', 'A'): 'd', ('D', 'D'): 'h', ('D', 'F'): 'o', ('D', 'G'): 'z', ('D', 'X'): 'k',
    ('F', 'A'): 'q', ('F', 'D'): 'f', ('F', 'F'): 'v', ('F', 'G'): 's', ('F', 'X'): 'n',
    ('G', 'A'): 'g', ('G', 'D'): 'i/j', ('G', 'F'): 'c', ('G', 'G'): 'u', ('G', 'X'): 'x',
    ('X', 'A'): 'm', ('X', 'D'): 'r', ('X', 'F'): 'e', ('X', 'G'): 'w', ('X', 'X'): 'y',
}

# Function to decrypt ADFGX cipher
def decrypt_adfgx():    
    cipher_text = input("Input ADFGX cipher text: ")
    
    if len(cipher_text) % 2 != 0 or any(c not in 'ADFGX' for c in cipher_text):
        print("FAILED TO DECRYPT")
        return
    
    decrypted_message = ""
    for i in range(0, len(cipher_text), 2):
        pair = (cipher_text[i], cipher_text[i+1])
        if pair in cipher_key:
            decrypted_message += cipher_key[pair]
        else:
            print("FAILED TO DECRYPT")
            return
    
    print(decrypted_message)

decrypt_adfgx()
