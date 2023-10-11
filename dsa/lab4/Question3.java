public class Question3 {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
    
        int[] arr1 = {5, 7, 17, 13, 11};
        int[] arr2 = {12, 10, 2, 4, 6};
    
        for (int num : arr1) {
            list1.add(num);
        }
    
        for (int num : arr2) {
            list2.add(num);
        }
    
        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);
    
        list1.mergeAlternate(list2);
    
        System.out.println("Merged List 1: " + list1);
        System.out.println("Merged List 2: " + list2); 
    }
    
}
