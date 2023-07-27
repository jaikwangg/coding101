import java.util.Scanner;
import java.lang.Math;

public class yakkinbualoy {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("x1 = ");
        double x1 = sc.nextDouble();
        System.out.print("x2 = ");
        double x2 = sc.nextDouble();
        System.out.print("y1 = ");
        double y1 = sc.nextDouble();
        System.out.print("y2 = ");
        double y2 = sc.nextDouble();
        double d = Math.sqrt(((x1-x2)*(x1-x2))+((y1-y2)*(y1-y2)));
        System.out.println("d = "+d);
        sc.close();
    }
}
