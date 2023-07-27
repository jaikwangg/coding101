import java.util.Arrays;
import java.util.Scanner;
public class Quiz2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(); //column
        int N = sc.nextInt(); //row
        int [][] Arr2D = new int [N][M];
        for(int i=0 ;i<N ;i++){
            for(int j=0 ;j<M ;j++){
              Arr2D[i][j] = sc.nextInt();
            }
        }
        sc.close();
        int [][] finalmap = wayto9(Arr2D);
        for(int i=0; i<finalmap.length; i++){
            System.out.println(Arrays.toString(finalmap[i]));
        }
    }
    static int [][] wayto9(int[][] Arr2D) {
        for(int r=0 ; r<Arr2D.length ;r++){
            for(int c=0 ; c<Arr2D[0].length ;c++){
                if(Arr2D[r][c] == 9){ // find 9
                    if(r-1>=0 &&  Arr2D[r-1][c] == 1){
                        Arr2D[r-1][c] = 2;
                    }if(r+1<Arr2D.length && Arr2D[r+1][c] == 1){
                        Arr2D[r+1][c] = 2;
                    }if(c-1>=0 && Arr2D[r][c-1] == 1){
                        Arr2D[r][c-1] = 2;
                    }if(c+1<Arr2D[0].length && Arr2D[r][c+1] == 1){
                        Arr2D[r][c+1] = 2;
                    }
                }
            }
        }
        int q=1;
        while (q==0) {
            for(int r=0 ; r<Arr2D.length ;r++){
                for(int c=0 ; c<Arr2D[0].length ;c++){
                    if(Arr2D[r][c] == 2){ // find way to -1
                        if(r-1>=0 &&  Arr2D[r-1][c] == 1){
                            Arr2D[r-1][c] = 2;
                        }else if(r+1<Arr2D.length && Arr2D[r+1][c] == 1){
                         Arr2D[r+1][c] = 2;
                        }else if(c-1>=0 && Arr2D[r][c-1] == 1){
                            Arr2D[r][c-1] = 2;
                        }else if(c+1<Arr2D[0].length && Arr2D[r][c+1] == 1){
                            Arr2D[r][c+1] = 2;
                        }
                    }
                }
            }
        }
        return Arr2D;
    }
}
