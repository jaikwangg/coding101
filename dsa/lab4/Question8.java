public class Question8 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        LinkedList list2 = new LinkedList();

        int[] arr = {1, 9, 9, 9};
    
        for (int num : arr) {
            list.add(num);
        }
    
        System.out.println("Original Linked List: " + list);
    
        list.addOneToNumber();
    
        System.out.println("Linked List after adding 1: " + list);

        int[] arr2 = {1, 2, 3, 4};
    
        for (int num : arr2) {
            list2.add(num);
        }
    
        System.out.println("Original Linked List: " + list2);
    
        list2.addOneToNumber();
    
        System.out.println("Linked List after adding 1: " + list2);
    }
    
    
}
