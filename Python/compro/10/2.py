def count_startswith_lines():
    print(' *** Find startswith lines ***')
    
    user_input = input("Enter file name : ").split()
    
    if len(user_input) != 2:
        print("Please provide both file name and search word.")
        return
    
    file_name, search_word = user_input[0], user_input[1]
    
    try:
        with open(file_name, 'r') as file:
            lines = file.readlines()

        total_lines = len(lines)
        print(f"Total lines : {total_lines}")

        count = sum(1 for line in lines if line.startswith(search_word))
        print(f'The number of lines staring with "{search_word}" is {count}')
    
    except FileNotFoundError:
        print(f"File '{file_name}' not found. Please check the file name.")

count_startswith_lines()
