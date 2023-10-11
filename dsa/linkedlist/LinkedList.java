public class LinkedList {

    public Node head = null;;

    public LinkedList()
    {
    }

    public int size()
    {
        int n = 0;
        Node cur = head;
        while (cur != null)
        {
            n++;
            cur = cur.next;
        }
        return (n);
    }

    public Node getLast()
    {
        if (head == null)
        {
            System.out.println("head is null");
            return head;
        }
        Node cur = head;
        while (cur.next != null)
            cur = cur.next;
        return (cur);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("");
        Node cur = head;
        while (cur != null)
        {
            sb.append(cur.toString() + " -> ");
            if (cur.next == null)
                sb.append("null");
            cur = cur.next;
        }
        return sb.toString();
    }

    public void add(int data)
    {
        Node n = new Node(data);
        if (head == null)
        {
            head = n;
            return;
        }
        getLast().next = n;
    }

    public void insert(int data)
    {
        Node newNode = new Node(data);
        if (head == null || data < head.data)
        {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node cur = head;
        while (cur.next != null && cur.next.data < data)
        {
            cur = cur.next;
        }
        newNode.next = cur.next;
        cur.next = newNode;
    }


    public Node find(int data)
    {
        Node cur = head;
        while (cur != null)
        {
            if (cur.data == data)
            {
                return (cur);
            }
            cur = cur.next;
        }
        System.out.println("data not found in linked list");
        return (null);
    }

    public void delete(int data)
        {
            Node cur = head;
            if (cur.data == data)
            {
                head = cur.next;
                return;
            }
            while (cur.next != null && cur.next.data != data)
            {
                cur = cur.next;
            }
            if (cur.next != null)
                cur.next = cur.next.next;
            else
                System.out.println("item to delete not found in liked list : " + data);
        }
        public void mergeAlternate(LinkedList list2) {
        if (list2 == null || list2.head == null) {
            return; 
        }

        Node current1 = head;
        Node current2 = list2.head;
        Node next1, next2;

        while (current1 != null && current2 != null) {
            next1 = current1.next;
            next2 = current2.next;

            current1.next = current2;
            current2.next = next1;

            current1 = next1;
            current2 = next2;
        }

        list2.head = null;
    }
    public int findMiddle(LinkedList list) {
        Node slow = list.head;
        Node fast = list.head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }
    public void addOneToNumber() {
        Node current = head;
        Node lastNonNine = null;
    
        while (current != null) {
            if (current.data != 9) {
                lastNonNine = current;
            }
            current = current.next;
        }
    
        if (lastNonNine == null) {
            Node newHead = new Node(1);
            newHead.next = head;
            head = newHead;
        } else {
            lastNonNine.data++;
    
            current = lastNonNine.next;
            while (current != null) {
                current.data = 0;
                current = current.next;
            }
        }
    }
    public void rotate(int k) {
        if (head == null || k <= 0) {
            return;
        }
    
        int size = size();
        k = k % size; 
    
        Node current = head;
    
        for (int i = 1; i < k; i++) {
            current = current.next;
        }
    
        Node newHead = current.next;
        current.next = null;
    
        Node temp = newHead;
        while (temp.next != null) {
            temp = temp.next;
        }
    
        temp.next = head;
        head = newHead;
    }    
}
