import java.util.Arrays;

public class MergeSort_650776 {
    public static void main(String[] args) {
        System.out.println("demo1");
        demo1();
        System.out.println("demo2");
        demo2_descending();
        System.out.println("demo3");
        demo3_multi_key();
    }

    static void demo1() {
        int[] data = {8, 3, 2, 9, 7, 1, 4};
        m_sort(data, 0);
        System.out.println(Arrays.toString(data));

    }

    static void demo2_descending() {
        int[][] data = {{11, 88}, {33, 99}, {22, 77}};
        m_sort(data, 0);
        for (int row = 0; row < data.length; row++)
            System.out.println(Arrays.toString(data[row]));
    }

    static void demo3_multi_key() {
        int[][] data = {
                {11, 22, 33, 44},
                {19, 17, 63, 57},
                {17, 22, 18, 15},
                {12, 18, 73, 84},
                {14, 27, 33, 55}
        };

        m_sort(data, 1, 2, 0);
        for (int row = 0; row < data.length; row++)
            System.out.println(Arrays.toString(data[row]));
    }

    static void m_sort(int[] input, int pass) {
        if (input.length <= 1)
            return;

        int mid = input.length / 2;
        int[] left = Arrays.copyOfRange(input, 0, mid);
        int[] right = Arrays.copyOfRange(input, mid, input.length);
        pass++;
        //System.out.println(pass);
        m_sort(left, pass);
        m_sort(right, pass);
        
        merge(input, left, right, pass);
    }

    static void merge(int[] input, int[] left, int[] right, int pass) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                input[k++] = left[i++];
            } else {
                input[k++] = right[j++];
            }
        }

        while (i < left.length) {
            input[k++] = left[i++];
        }

        while (j < right.length) {
            input[k++] = right[j++];
        }
    }

    static void m_sort(int[][] input, int pass) {
        if (input.length <= 1)
            return;

        int mid = input.length / 2;
        int[][] left = Arrays.copyOfRange(input, 0, mid);
        int[][] right = Arrays.copyOfRange(input, mid, input.length);
        pass++;
        //System.out.println(pass);
        m_sort(left, pass);
        m_sort(right, pass);

        merge(input, left, right, pass);
    }

    static void merge(int[][] input, int[][] left, int[][] right, int pass) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i][0] < right[j][0]) {
                input[k++] = left[i++];
            } else {
                input[k++] = right[j++];
            }
        }

        while (i < left.length) {
            input[k++] = left[i++];
        }

        while (j < right.length) {
            input[k++] = right[j++];
        }
    }

    static void m_sort(int[][] input, int key1, int key2, int pass) {
        if (input.length <= 1)
            return;

        int mid = input.length / 2;
        int[][] left = Arrays.copyOfRange(input, 0, mid);
        int[][] right = Arrays.copyOfRange(input, mid, input.length);
        pass++;
        //System.out.println(pass);
        m_sort(left, key1, key2, pass);
        m_sort(right, key1, key2, pass);

        merge(input, left, right, key1, key2, pass);
    }

    static void merge(int[][] input, int[][] left, int[][] right, int key1, int key2, int pass) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i][key1] > right[j][key1] || (left[i][key1] == right[j][key1] && left[i][key2] > right[j][key2])) {
                input[k++] = left[i++];
            } else {
                input[k++] = right[j++];
            }
        }

        while (i < left.length) {
            input[k++] = left[i++];
        }

        while (j < right.length) {
            input[k++] = right[j++];
        }
    }
}
