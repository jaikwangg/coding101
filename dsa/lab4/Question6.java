public class Question6 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        LinkedList list2 = new LinkedList();
    
        int[] arr = {1, 2, 3, 4, 5};
        
        for (int num : arr) {
            list.add(num);
        }
    
        int middle = list.findMiddle(list);
        System.out.println("Middle element: " + middle);

        int[] arr2 = {1, 2, 3, 4, 5, 6};
        
        for (int num : arr2) {
            list2.add(num);
        }
    
        int middle2 = list2.findMiddle(list2);
        System.out.println("Middle element: " + middle2);
    }
}
