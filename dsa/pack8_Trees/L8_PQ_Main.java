package pack8_Trees; 
import java.util.ArrayList;

public class L8_PQ_Main {
    static ArrayList<Integer> least3;

    public static void main(String[] args) {
        System.out.println("-demo1---");
        demo1();
        // System.out.println("-demo2---");
        // demo2();
    }

    static void demo1() {
        least3 = new ArrayList<>();
        MyMinHeap heap = new MyMinHeap();
        heap.insert(11);
        heap.insert(15);
        heap.insert(16);
        heap.insert(13);
        heap.insert(17);
        heap.insert(18);
        System.out.println("heap structure is " + heap);
        least3.add(heap.remove());
        least3.add(heap.remove());
        least3.add(heap.remove());
        System.out.println("least 3 value is " + least3);
    }

    // Define demo2() if needed

    static class MyMinHeap {
        private ArrayList<Integer> heap;

        public MyMinHeap() {
            heap = new ArrayList<>();
        }

        public void insert(int d) {
            // Implement the insert method
        }

        public int remove() {
            // Implement the remove method
            return 0; // Replace with the actual implementation
        }

        @Override
        public String toString() {
            // Implement the toString method
            return ""; // Replace with the actual implementation
        }
    }

    // Define MyPriorityQueue if needed
}
