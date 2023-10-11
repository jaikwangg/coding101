import java.util.Scanner;

public class GaussianElimination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of equations: ");
        int numEquations = scanner.nextInt();
        System.out.print("Enter the number of variables: ");
        int numVariables = scanner.nextInt();

        double[][] A = new double[numEquations][numVariables];
        double[] B = new double[numEquations];

        for (int i = 0; i < numEquations; i++) {
            System.out.println("Equation " + (i + 1) + ":");
            for (int j = 0; j < numVariables; j++) {
                System.out.print("A[" + i + "][" + j + "] = ");
                A[i][j] = scanner.nextDouble();
            }
            System.out.print("B[" + i + "] = ");
            B[i] = scanner.nextDouble();
        }

        double[] X = solve(A, B);

        if (X != null) {
            System.out.println("Solution:");
            for (int i = 0; i < X.length; i++) {
                System.out.println("X[" + i + "] = " + X[i]);
            }
        } else {
            System.out.println("No unique solution exists.");
        }

        scanner.close();
    }

    public static double[] solve(double[][] A, double[] B) {
        int numEquations = A.length;
        int numVariables = A[0].length;

        // Forward elimination
        for (int pivot = 0; pivot < numEquations - 1; pivot++) {
            for (int row = pivot + 1; row < numEquations; row++) {
                double factor = A[row][pivot] / A[pivot][pivot];
                for (int col = pivot; col < numVariables; col++) {
                    A[row][col] -= factor * A[pivot][col];
                }
                B[row] -= factor * B[pivot];
            }
        }

        // Back substitution
        double[] X = new double[numVariables];
        for (int i = numEquations - 1; i >= 0; i--) {
            X[i] = B[i] / A[i][i];
            for (int j = i + 1; j < numVariables; j++) {
                X[i] -= A[i][j] * X[j];
            }
        }

        for (int i = 0; i < numEquations; i++) {
            if (A[i][i] == 0) {
                return null;
            }
        }

        return X;
    }
}
