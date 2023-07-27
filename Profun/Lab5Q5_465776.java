public class Lab5Q5_465776 {
    public static void main(String[] args) {
            //n=4
            for(int n=1; n<5; n++){
                for(int m=0 ; m<6-n ; m++){
                    System.out.print(" ");
                }
                for(int p=0 ; p<2*n-1 ; p++){
                    System.out.print("*");
                }
                System.out.println(" ");
            }
            for(int n=1; n<5; n++){
                for(int m=0 ; m<5-n ; m++){
                    System.out.print(" ");
                }
                for(int p=0 ; p<2*n+1 ; p++){
                    System.out.print("*");
                }
                System.out.println(" ");
            }
            for(int n=1; n<5; n++){
                for(int m=0 ; m<4-n ; m++){
                    System.out.print(" ");
                }
                for(int p=0 ; p<2*n+3 ; p++){
                    System.out.print("*");
                }
                System.out.println(" ");
            }
            for(int n=1; n<5; n++){
                for(int m=0 ; m<4 ; m++){
                    System.out.print(" ");
                }
                for(int p=0 ; p<3 ; p++){
                    System.out.print("*");
                }
                System.out.println(" ");
                if(n==3){
                    break;
                }
            }
        }
    }
