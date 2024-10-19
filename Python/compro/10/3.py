def count_lines_with_word(filename, word):
    try:
        with open(filename, 'r') as file:
            lines = file.readlines()  
            total_lines = len(lines)  
            count = 0  
            
            for line in lines:
                if word in line:
                    count += 1

            return count, total_lines 
    except FileNotFoundError:
        print(f"Error: The file '{filename}' was not found.")
        return 0, 0 

def main():
    print(" *** Find number of lines for specific word ***")
    input_data = input("Enter file name and word : ")
    
    try:
        filename, word = input_data.split() 
    except ValueError:
        print("Error: Please enter both the filename and the word separated by a space.")
        return

    count, total = count_lines_with_word(filename, word)

    # Display the results
    print(f"Number of lines having \"{word}\" => {count}")
    print(f"Total lines => {total}")

if __name__ == "__main__":
    main()
