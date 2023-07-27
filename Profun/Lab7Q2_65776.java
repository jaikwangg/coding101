public class Lab7Q2_65776{
    static int maxElement(int [] arr) {
        int max = arr[0];
        for(int i = 1 ;i<arr.length;i++){
            if(max<=arr[i]){
                max = arr[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int [] data = {7, 1, 2, -1, 3, 4, 10, -12, 3, 21, -9};
        System.out.println("maxElement is "+maxElement(data));
    }
}