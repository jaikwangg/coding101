def to_kebab_case(text):
    lower_text = text.lower()
    kebab_case_text = lower_text.replace(' ', '-')
    return kebab_case_text

def main():
    print("Enter some words: ", end="")
    input_str = input().strip() 
    
    kebab_case_result = to_kebab_case(input_str)
    print(f"Kebab-case: {kebab_case_result}")

main()
