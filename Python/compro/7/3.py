def toggle_first_vowel(word):
    vowels = "aeiouAEIOU"
    new_word = list(word)
    
    for i, char in enumerate(word):
        if char in vowels:
            if char.islower():
                new_word[i] = char.upper()
            else:
                new_word[i] = char.lower()
            break
    
    return ''.join(new_word)

def main():
    print(" *** Toggle first vowel ***")
    input_str = input("Enter words : ")
    
    words = input_str.split()
    toggled_words = [toggle_first_vowel(word) for word in words]
    result = ' '.join(toggled_words)
    
    print(result)
    print("===== End of program =====")

main()
