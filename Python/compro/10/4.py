def find_word_in_file(filename, search_term):
    try:
        with open(filename, 'r') as file:
            total_lines = 0
            line_count = 0
            line_sum = 0
            
            for index, line in enumerate(file):
                total_lines += 1
                if search_term in line:
                    line_count += 1
                    line_sum += index + 1  # Adding 1 to convert 0-index to 1-index
                
            return line_count, line_sum, total_lines
            
    except FileNotFoundError:
        return None, None, None  # File not found

def main():
    print(" *** File Error Handling ***")
    user_input = input("Enter file name and word : ").strip()
    if " " not in user_input:
        print("Please enter both a file name and a search term.")
        return
    
    filename, search_term = user_input.split(" ", 1)
    
    line_count, line_sum, total_lines = find_word_in_file(filename, search_term)
    
    if line_count is None:
        print(f"Error can not open file => {filename}")
    else:
        print(f"Number of lines having \"{search_term}\" => {line_count}")
        print(f"Sum of line number => {line_sum}")
        print(f"Total lines => {total_lines}")

if __name__ == "__main__":
    main()
