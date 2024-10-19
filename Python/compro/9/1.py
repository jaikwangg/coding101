def create_dictionary():
    print(" *** Creating Dictionary ***")
    
    text = input("Enter text : ")

    data_list = text.split()

    dictionary = {data_list[i]: data_list[i+1] for i in range(0, len(data_list), 2)}
    
    print(dictionary)

create_dictionary()
