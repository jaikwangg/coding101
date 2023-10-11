public class mergeAlternate {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.add(5);
        list1.add(7);
        list1.add(17);
        list1.add(13);
        list1.add(11);

        LinkedList list2 = new LinkedList();
        list2.add(12);
        list2.add(10);
        list2.add(2);
        list2.add(4);
        list2.add(6);

        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);

        list1.mergeAlternate(list2);

        System.out.println("Merged List 1: " + list1);
        System.out.println("Merged List 2: " + list2);

    }
}
