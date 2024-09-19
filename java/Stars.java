import java.util.Scanner;

public class Stars {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int c = n;

        for (int j = 1; j <= n; j++, c--) { 
            for (int k = 1; k <= n; k++) {
                if (j == k || j + k == n + 1) 
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
        kb.close();
    }
}
