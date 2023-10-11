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

def matrix_minor(matrix, row, col):
    return [row[:col] + row[col+1:] for row in (matrix[:row] + matrix[row+1:])]

def matrix_determinant(matrix):
    if len(matrix) == 2:
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]
    
    determinant = 0
    for col in range(len(matrix)):
        determinant += ((-1) ** col) * matrix[0][col] * matrix_determinant(matrix_minor(matrix, 0, col))
    return determinant

def matrix_cofactor(matrix):
    cofactor = []
    for row in range(len(matrix)):
        cofactor_row = []
        for col in range(len(matrix)):
            minor = matrix_minor(matrix, row, col)
            cofactor_row.append(((-1) ** (row + col)) * matrix_determinant(minor))
        cofactor.append(cofactor_row)
    return cofactor

def matrix_transpose(matrix):
    return [[matrix[j][i] for j in range(len(matrix))] for i in range(len(matrix[0]))]

def matrix_scalar_multiply(matrix, scalar):
    return [[scalar * element for element in row] for row in matrix]

def matrix_inverse(matrix):
    determinant = matrix_determinant(matrix)
    if determinant == 0:
        return None

    cofactor = matrix_cofactor(matrix)
    adjugate = matrix_transpose(cofactor)
    inverse = matrix_scalar_multiply(adjugate, 1 / determinant)

    return inverse

def main():
    rows = int(input("Enter the number of rows for the matrix: "))
    cols = int(input("Enter the number of columns for the matrix: "))

    print("Enter the elements of the matrix:")
    matrix = input_matrix(rows, cols)

    inverse = matrix_inverse(matrix)
    if inverse is not None:
        print("\nInverse Matrix:")
        display_matrix(inverse)
    else:
        print("Matrix is singular and cannot be inverted.")

main()
