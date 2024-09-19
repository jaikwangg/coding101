def add_numbers_to_words(words):
    word_list = words.split()
    
    numbered_words = [f"{word}{i+1}" for i, word in enumerate(word_list)]
    
    return numbered_words

def main():
    print(" *** Adding number ***")
    input_str = input("Enter your words : ")
    
    numbered_words = add_numbers_to_words(input_str)
    
    print(numbered_words)
    print(" ".join(numbered_words))

main()
