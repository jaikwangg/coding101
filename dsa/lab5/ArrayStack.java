

public class ArrayStack {
    private Double[] stack;
    private int top;
    private int capacity;

    public ArrayStack(int size) {
        capacity = size;
        stack = new Double[capacity];
        top = -1;
    }

    public void push(Double d) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push " + d);
            return;
        }
        stack[++top] = d;
    }

    public Double pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return (double) -1; 
        }
        return stack[top--];
    }

    public Double top() {
        if (isEmpty()) {
            System.out.println("Stack is empty. No top element.");
            return (double) -1; 
        }
        return stack[top];
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Stack is empty.";
        }

        StringBuilder sb = new StringBuilder("Stack: ");
        for (int i = 0; i <= top; i++) {
            sb.append(stack[i]).append(" ");
        }
        return sb.toString();
    }
}
