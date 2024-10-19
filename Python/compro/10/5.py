def analyze_file(filename, search_word): 
    try:
        with open(filename, 'r') as file:
            total_lines = 0
            word_count = 0
            line_sum = 0
            char_counts = {}

            for index, line in enumerate(file):
                total_lines += 1
                line = line.strip()  # Remove any leading/trailing whitespace
                
                # Check if the search word exists in the line (case-sensitive)
                if search_word in line:
                    line_word_count = line.count(search_word)
                    word_count += line_word_count
                    line_sum += (index + 1)  # Add 1 for 1-indexed line number
                    
                    # Count characters in the line
                    for char in line:
                        if char.isalpha():  # Count only alphabetic characters
                            char_counts[char] = char_counts.get(char, 0) + 1
            
            return word_count, line_sum, total_lines, char_counts
            
    except FileNotFoundError:
        return None, None, None, None  # File not found

def main():
    print(" *** Histogram *** ")
    user_input = input("Enter file name and word : ").strip()
    
    if " " not in user_input:
        print("Please enter both a file name and a search term.")
        return
    
    filename, search_word = user_input.split(" ", 1)
    
    word_count, line_sum, total_lines, char_counts = analyze_file(filename, search_word)

    if word_count is None:
        print(f"Error can not open file => {filename}")
    else:
        print(f'Number of "{search_word}" => {word_count}')
        print(f'Sum of line number => {line_sum:,}')  # Formatting line sum with commas
        print(f'Total lines => {total_lines:,}')

        # Sort by count (descending), then by character (descending if counts are equal)
        sorted_chars = sorted(char_counts.items(), key=lambda x: (-x[1], -ord(x[0])))
        top_three_chars = sorted_chars[:3]

        for char, count in top_three_chars:
            print(f' {char}  => {"*" * count} {count}')
        
    print("===== End of program =====")

if __name__ == "__main__":
    main()
