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

def transpose_matrix(matrix):
    rows = len(matrix)
    cols = len(matrix[0])
    transposed_matrix = [[matrix[j][i] for j in range(rows)] for i in range(cols)]
    return transposed_matrix

def multiply_matrices(matrix1, matrix2):
    rows1 = len(matrix1)
    cols1 = len(matrix1[0])
    rows2 = len(matrix2)
    cols2 = len(matrix2[0])

    if cols1 != rows2:
        print("Error: The number of columns in the first matrix must be equal to the number of rows in the second matrix.")
        return None

    result_matrix = [[0 for _ in range(cols2)] for _ in range(rows1)]

    for i in range(rows1):
        for j in range(cols2):
            for k in range(cols1):
                result_matrix[i][j] += matrix1[i][k] * matrix2[k][j]

    return result_matrix

def main():
    try:
        rows1 = int(input("Enter the number of rows in the first matrix: "))
        cols1 = int(input("Enter the number of columns in the first matrix: "))

        print("Enter the elements of the first matrix:")
        matrix1 = input_matrix(rows1, cols1)
        ans = input("Do you want to tranpose this matrix ? y/n")
        if(ans.lower() == 'y'):
          matrix1 = transpose_matrix(matrix1)
          display_matrix(matrix1)

        rows2 = int(input("Enter the number of rows in the second matrix: "))
        cols2 = int(input("Enter the number of columns in the second matrix: "))
        
        print("Enter the elements of the second matrix:")
        matrix2 = input_matrix(rows2, cols2)
        ans = input("Do you want to tranpose this matrix ? y/n")
        if(ans.lower() == 'y'):
          matrix2 = transpose_matrix(matrix2)
          display_matrix(matrix2)

        print("\nFirst Matrix:")
        display_matrix(matrix1)

        print("\nTransposed First Matrix:")
        transposed_matrix1 = transpose_matrix(matrix1)
        display_matrix(transposed_matrix1)

        print("\nSecond Matrix:")
        display_matrix(matrix2)

        print("\nTransposed Second Matrix:")
        transposed_matrix2 = transpose_matrix(matrix2)
        display_matrix(transposed_matrix2)

        result_matrix = multiply_matrices(matrix1, matrix2)
        if result_matrix:
            print("\nResultant Matrix:")
            display_matrix(result_matrix)

    except ValueError:
        print("Invalid input. Please enter valid numeric values.")

main()
