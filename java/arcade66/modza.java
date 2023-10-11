package arcade66;

import java.util.Scanner;

public class modza {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String s = scanner.next();

        String result = removeChars(n, s);
        System.out.println(result);
        scanner.close();
    }
    public static String removeChars(int n, String s) {
        int[] freq = new int[26];
        int count = 0;
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (freq[c - 'a'] == 0 && count < n) {
                freq[c - 'a'] = 1;
                count++;
            } else {
                sb.append(c);
            }
        }

        if (count <= n) {
            return "All Disappeared!!!";
        }

        return sb.toString();
    }
}
