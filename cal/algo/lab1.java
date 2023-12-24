

import java.util.Scanner;

public class lab1 {

    public static void findX(double A, double B, double C) {
        if (A == 0) {
            if (B == 0) {
                System.out.println("This equation is a constant equation");
            } else {
                double x = -C / B;
                System.out.println("This equation represents a straight line");
                System.out.printf("x = %.2f\n", x);
            }
        } else {
            double check = B * B - 4 * A * C;

            if (check > 0) {
                double x1 = (-B + Math.sqrt(check)) / (2 * A);
                double x2 = (-B - Math.sqrt(check)) / (2 * A);
                System.out.printf("x1 = %.2f\n", x1);
                System.out.printf("x2 = %.2f\n", x2);
            } else if (check == 0) {
                double x = -B / (2 * A);
                System.out.printf("x = %.2f\n", x);
            } else {
                System.out.println("This equation has no real solutions");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Given Ax^2 + Bx + C");
        System.out.print("Please enter values for A, B, and C: ");

        double A = scanner.nextDouble();
        double B = scanner.nextDouble();
        double C = scanner.nextDouble();

        findX(A, B, C);
    }
}
