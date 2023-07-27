def input_matrix(rows, cols):
    matrix = []
    for i in range(rows):
        row = []
        for j in range(cols):
            element = float(input(f"Enter element at position ({i+1}, {j+1}): "))
            row.append(element)
        matrix.append(row)
    return matrix

def display_matrix(matrix):
    for row in matrix:
        print(row)

def matrix_determinant(matrix):
    n = len(matrix)

    if n == 1:
        return matrix[0][0]
    elif n == 2:
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]

    determinant = 0
    for col in range(n):
        sub_matrix = [[matrix[i][j] for j in range(n) if j != col] for i in range(1, n)]
        sign = 1 if col % 2 == 0 else -1
        determinant += matrix[0][col] * matrix_determinant(sub_matrix) * sign

    return determinant

def main():
    try:
        rows = int(input("Enter the number of rows in the square matrix: "))
        cols = int(input("Enter the number of columns in the square matrix: "))

        if rows != cols:
            print("The matrix must be square.")
            return

        print("Enter the elements of the matrix:")
        matrix = input_matrix(rows, cols)

        print("\nMatrix:")
        display_matrix(matrix)

        determinant = matrix_determinant(matrix)
        print("\nDeterminant of the Matrix:", determinant)

    except ValueError:
        print("Invalid input. Please enter valid numeric values.")

main()
