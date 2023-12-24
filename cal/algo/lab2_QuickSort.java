import java.util.Scanner;

public class lab2_QuickSort {
    public static void main(String[] args) {
        //65050776
        //int[] data = {12 ,76 ,32 ,75 ,16 ,45 ,39 ,86 ,23 ,77};
        //
        // System.out.println("Unsorted Array:");
        // for (int i = 0; i <  data.length; i++) {
        //     System.out.print(data[i] + " ");
        // }
        // System.out.println();
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.println("input data : (12 ,76 ,32 ,75 ,16 ,45 ,39 ,86 ,23 ,77)");
        int[] data = new int[10];

        for (int i = 0; i < data.length; i++) {
            data[i] = scanner.nextInt();
        }

        System.out.println("Sorting:");
        quickSort(data, 0, data.length - 1);

        System.out.println("Sorted Array:");
        for (int i = 0; i <  data.length; i++) {
            System.out.print(data[i] + " ");
        }
        scanner.close();
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            for (int i = 0; i <  arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}