import java.util.Arrays;

public class Lab7_max_square_and_edit_distance {
    private static int max_so_far_for_recursion = -1;

    private static int[][] matrix;
    private static int rows;
    private static int cols;

    public static int find_max_area_recurse_entry(int[][] mat) {
        matrix = mat;
        rows = matrix.length;
        cols = matrix[0].length;
        max_so_far_for_recursion = -1;

        q1_1_find_max_area_recurse(matrix, 0, 0);

        return max_so_far_for_recursion * max_so_far_for_recursion;
    }

    private static int q1_1_find_max_area_recurse(int[][] mat, int r, int c) {
        if (r == rows || c == cols)
            return 0;
        //Q1
        if (mat[r][c] == 1) {
            int right = q1_1_find_max_area_recurse(mat, r, c + 1);
            int bottom = q1_1_find_max_area_recurse(mat, r + 1, c);
            int diagonal = q1_1_find_max_area_recurse(mat, r + 1, c + 1);

            int size = 1 + Math.min(Math.min(right, bottom), diagonal);

            max_so_far_for_recursion = Math.max(max_so_far_for_recursion, size);

            return size;
        }

        return 0;
    }

    public static int q2_string_edit_distance(String str1, String str2) {
        int[][] cache = new int[str1.length() + 1][str2.length() + 1];

        for (int[] row : cache)
            Arrays.fill(row, Integer.MAX_VALUE);

        for (int r = 0; r < cache.length; r++) {
            cache[r][str2.length()] = str2.length() - r;
        }

        for (int c = 0; c < cache[0].length; c++) {
            cache[str1.length()][c] = str1.length() - c;
        }

        for (int i = str1.length() - 1; i >= 0; i--) {
            for (int j = str2.length() - 1; j >= 0; j--) {
                //Q2
                if (str1.charAt(i) == str2.charAt(j)) {
                    cache[i][j] = cache[i + 1][j + 1];
                } else {
                    int insert = 1 + cache[i][j + 1];
                    int delete = 1 + cache[i + 1][j];
                    int replace = 1 + cache[i + 1][j + 1];

                    cache[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return cache[0][0];
    }

    public static void main(String[] args) {
        //Task 1
        int[][] matrix = {
            {1, 0, 1, 0, 0},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0},
            {0, 1, 1, 1, 0},
            {1, 1, 1, 1, 1}
        };

        int[][] data = { 
                        {0,1,1,0,1},
                        {1,1,0,1,0},
                        {0,1,1,1,0},
                        {1,1,1,1,0},
                        {1,1,1,1,1},
                        {0,0,0,0,0} 
        };

        int maxSquareSize = find_max_area_recurse_entry(matrix);
        System.out.println("Maximum size square sub-matrix with all 1s: " + maxSquareSize);

        maxSquareSize = find_max_area_recurse_entry(data);
        System.out.println("Maximum size square sub-matrix with all 1s: " + maxSquareSize);

        //Task 2
        String str1 = "yakkin";
        String str2 = "mookrata";
        int editDistance = q2_string_edit_distance(str1, str2);
        System.out.println("Edit distance between \"" + str1 + "\" and \"" + str2 + "\": " + editDistance);
    }
}
