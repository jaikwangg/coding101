def count_lines_in_file():
    print(' *** Find Total lines ***')
    file_name = input("Enter file name : ")
    try:
        with open(file_name, 'r') as file:
            lines = file.readlines()

        total_lines = len(lines)
        print(f"Total lines : {total_lines}")
    
    except FileNotFoundError:
        print(f"File '{file_name}' not found. Please check the file name.")

count_lines_in_file()
