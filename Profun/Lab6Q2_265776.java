public class Lab6Q2_265776 {
    public static void main(String[] args) {
        String input = "10 10 10 01 10 10";
        String[] a = input.split(" ");
        int segments = 1;
        int x = 0;
        for(int i = 1;i<a.length;i++){
            if(a[x].equals(a[i])){
                x++;
            }
            else{
                segments++;
                x++;
            }
        }
        System.out.println(segments);
    }
}
