def most_least_concatenation():
    print(" *** Show max/min key and their summation ***")
    
    text = input("Enter text : ")
    
    words = text.split()
    
    word_count = {}
    for word in words:
        word_count[word] = word_count.get(word, 0) + 1
    
    max_word = max(word_count, key=word_count.get)
    min_word = min(word_count, key=word_count.get)
    
    max_count = word_count[max_word]
    min_count = word_count[min_word]
    
    result = f"{max_word}{min_word} sum = {max_count + min_count}"
    
    print(result)

most_least_concatenation()
