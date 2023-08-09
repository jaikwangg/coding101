package arcade66;
import java.util.ArrayList;

public class sadboybutnotsoybad {
    public static void main(String[] args) {
        String sequence1 = "%$";
        String sequence2 = "$%";
        String sequence3 = "%%%$$$";

        System.out.println(doorSequence(sequence1)); // Output: [1, 1]
        System.out.println(doorSequence(sequence2)); // Output: If you love somebody, let them go, for if they return, they were always yours. And if they don’t, they never were.
        System.out.println(doorSequence(sequence3)); // Output: [1, 2, 3, 3, 2, 1]
    }

    public static String doorSequence(String sequence) {
        int opens = 0;
        ArrayList<Integer> doorPairs = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        for (char ch : sequence.toCharArray()) {
            if (ch == '%') {
                opens++;
            } else if (ch == '$') {
                if (opens == 0) {
                    return "If you love somebody, let them go, for if they return, they were always yours. And if they don't, they never were.";
                }
                doorPairs.add(opens);
                opens--;
            }
        }

        if (opens != 0) {
            return "If you love somebody, let them go, for if they return, they were always yours. And if they don't, they never were.";
        } else {
            result.append("[");
            for (int i = 0; i < doorPairs.size(); i++) {
                result.append(doorPairs.get(i));
                if (i != doorPairs.size()) {
                    result.append(", ");
                    result.append(doorPairs.get(i));
                }
            }
            result.append("]");
            return result.toString();
        }
    }
}
