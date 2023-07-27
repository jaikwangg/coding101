import java.util.Scanner;

public class Lab4Q265776 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number = ");
        int x = sc.nextInt();
        System.out.println("Enter number = ");
        int y = sc.nextInt();
        System.out.println("Enter number = ");
        int z = sc.nextInt();
        int a = (x>y)?y:x;
        int min = (a>z)?z:a;
        int sum =x+y+z-min;
        System.out.println("Summary = "+sum);
        sc.close();
    }
}
