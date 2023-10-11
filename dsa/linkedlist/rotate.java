public class rotate {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);

        System.out.println("Original List: " + list);
        list.rotate(3); 
        System.out.println("Rotated List: " + list);

    }
}
