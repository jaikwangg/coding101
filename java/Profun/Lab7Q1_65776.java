import java.util.Scanner;

public class Lab7Q1_65776 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(factorial(n));
        sc.close();
    }
    static int factorial(int n) {
        for(int i = n-1;i>=1;i--){
            n *= i;
        }
        return n;
    } 
}
