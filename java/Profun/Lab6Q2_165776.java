
import java.util.Arrays;

public class Lab6Q2_165776 {
    public static void main(String[] args) {
        int[] data = {7, 1, 2, -1, 3, 4, 10, -12, 3, 21, -9};
        Arrays.sort(data);
        int a = data.length-1;
        int sum = data[a];
        System.out.print("Max number = ");
        System.out.print(sum);
    }
}
