def process_commands(commands):
    shopping_list = ["egg", "ham", "water", "soda"]
    
    for command in commands:
        if not command:
            continue
        
        parts = command.split()
        if len(parts) != 2:
            print("Operation not supported!")
            return
        
        operation, item = parts
        item = item.lower()  

        if operation == 'a':
            if item not in shopping_list:
                shopping_list.append(item)
        elif operation == 'r':
            if item in shopping_list:
                shopping_list.remove(item)
        else:
            print("Operation not supported!")
            return
    
    print(f"Final shopping list is {shopping_list}")

def main():
    print("*** Shopping List ***")
    input_str = input("Enter some pairs of (operation, item): ").strip()
    
    commands = input_str.split(',')
    
    process_commands(commands)

main()
