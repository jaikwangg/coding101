def letter_count():
    print(" *** Letter count ***")
    
    text = input("Enter : ")
    
    words = text.split()
    
    word_count_dict = {}
    
    total_count = {}

    for word in words:
        word_count = {}
        for char in word:
            word_count[char] = word_count.get(char, 0) + 1
            total_count[char] = total_count.get(char, 0) + 1
        word_count_dict[word] = word_count
    
    for word in words:
        print(f"{word} = {word_count_dict[word]}")
    
    print(f"{text} = {total_count}")
    
    max_char = max(total_count, key=total_count.get)
    max_count = total_count[max_char]
    
    print(f"Maximum Character Count: {max_char} {max_count}")

letter_count()
