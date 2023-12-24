import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class adventCode3_1 {
    static List<String> userInputList = new ArrayList<>();
    static int summary = 0;

    public static void inputPuzzle() {
        Scanner sc = new Scanner(System.in);
        String userInput;
        while (true) {
            userInput = sc.nextLine();
            if (userInput.isBlank())
                break;
            userInputList.add(userInput);
        }
        sc.close();
    }

    public static void calculatePartNumbers() {
        for (int i = 0; i < userInputList.size(); i++) {
            StringBuilder numberBuilder = new StringBuilder();
            int adjacent = 0;
            for (int j = 0; j < userInputList.get(i).length(); j++) {
                char currentChar = userInputList.get(i).charAt(j);
                if (Character.isDigit(currentChar)) {
                    numberBuilder.append(currentChar);
                    if (isAdjacentSymbol(i, j))
                        adjacent += 1;
                } else {
                    if (adjacent > 0)
                        summary += Integer.parseInt(numberBuilder.toString());
                    numberBuilder.setLength(0);
                    adjacent = 0;
                }
            }
        }
    }

    private static boolean isAdjacentSymbol(int row, int col) {
        int[][] directions = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
        for (int[] check : directions) {
            int newRow = row + check[0];
            int newCol = col + check[1];
            if (newRow >= 0 && newRow < userInputList.size() && newCol >= 0
                    && newCol < userInputList.get(row).length()) {
                char adjacentChar = userInputList.get(newRow).charAt(newCol);
                if (adjacentChar != '.' && adjacentChar != ' ' && !Character.isDigit(adjacentChar))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String fileName = "input.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(new File(fileName)))) {
            String line;
            while ((line = br.readLine()) != null) {
                userInputList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        calculatePartNumbers();
        System.out.println("Sum of all of the part numbers in the engine schematic: " + summary);
    }
}