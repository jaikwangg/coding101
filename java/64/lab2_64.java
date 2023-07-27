import java.util.Scanner;

public class lab2_64 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.print("R = ");
        int R = sc.nextInt();
        Double sum = 3.1416*R*R/2;
        System.out.println("Summary = "+sum);
        sc.close();
    }
}
