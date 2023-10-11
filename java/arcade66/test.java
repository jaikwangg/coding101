package arcade66;

import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = 0, close = 0, open = 0, oCount = 0, j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '%' || s.charAt(i) == '$') {
                n++;
                if (s.charAt(i) == '%')
                    open++;
                else if (s.charAt(i) == '$')
                    close++;
            }
        }
        int[] op = new int[n];
        ArrayList<Integer> sq = new ArrayList<>();

        if (open >= close) {
            loop1: while (true) {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == '%') {
                        op[j++] = ++oCount;
                        sq.add(oCount);
                    } else if (s.charAt(i) == '$') {
                        if (sq.size() == 0) {
                            System.out.println(
                                    "If you love somebody, let them go, for if they return, they were always yours. And if they don't, they never were.");
                            break loop1;
                        }
                        op[j++] = sq.get(sq.size() - 1);
                        sq.remove(sq.size() - 1);
                    }
                }
                System.out.println(Arrays.toString(op));
                break loop1;
            }
        } else {
            System.out.println(
                    "If you love somebody, let them go, for if they return, they were always yours. And if they don't, they never were.");
        }
        sc.close();
    }
}
