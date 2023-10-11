public class ArrayQueue {
    private int[] arr;
    private int front, rear, size;

    public ArrayQueue(int capacity) {
        arr = new int[capacity];
        front = rear = size = 0;
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }
        arr[rear] = data;
        rear = (rear + 1) % arr.length;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1; // You can choose a different default value.
        }
        int data = arr[front];
        front = (front + 1) % arr.length;
        size--;
        return data;
    }

    public int front() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No front element.");
            return -1; // You can choose a different default value.
        }
        return arr[front];
    }

    public boolean isFull() {
        return size == arr.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(arr[(front + i) % arr.length]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
