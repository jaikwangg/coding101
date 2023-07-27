public class Lab5Q5_365776 {
    public static void main(String[] args) {
        
        for(int n=1 ; n<=4; n++){
            for(int m=0 ; m<4-n ; m++){
                System.out.print(" ");
            }
            for(int p=0 ; p<2*n-1 ; p++){
                System.out.print("p");
            }
            System.out.println(" ");
        }
    }
}
