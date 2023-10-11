public class LinkedListQueue {
    private Node front, rear;

    public LinkedListQueue() {
        front = rear = null;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1; // You can choose a different default value.
        }
        int data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }

    public int front() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No front element.");
            return -1; // You can choose a different default value.
        }
        return front.data;
    }

    public boolean isFull() {
        // Linked list-based queue doesn't have a fixed capacity
        return false;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node current = front;
        while (current != null) {
            sb.append(current.data);
            current = current.next;
            if (current != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
