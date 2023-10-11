package arcade66;

import java.util.Scanner;

public class nomsy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int Ax = scanner.nextInt();
        int Ay = scanner.nextInt();
        int Bx = scanner.nextInt();
        int By = scanner.nextInt();
        int Cx = scanner.nextInt();
        int Cy = scanner.nextInt();

        String result = canEscape(n, Ax, Ay, Bx, By, Cx, Cy);
        System.out.println(result);
        scanner.close();
    }

    public static String canEscape(int n, int ax, int ay, int bx, int by, int cx, int cy) {
        if (ax == bx || ay == by || Math.abs(ax - bx) == Math.abs(ay - by)) {
            if (Math.abs(ax - cx) == Math.abs(ay - cy)) {
                return "No";
            }
        }

        return "Yes";
    }
}
