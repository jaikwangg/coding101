import java.util.Scanner;
public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int M = sc.nextInt();
    int N = sc.nextInt();
    int [][] map = new int [N][M];
    int x_start = 0;
    int y_start = 0;
    for (int i = 0 ; i < N ; i++){
      for (int j = 0 ; j < M ; j++){
        map[i][j] = sc.nextInt();
        if(map[i][j]==-1){
          x_start = j;
          y_start = i;
        }
      }
    }
    int move_x = x_start;
    int move_y = y_start;
    if((map[x_start-1][y_start]==9 || map[x_start-1][y_start]==1) && x_start-1>0 &&y_start>0 &&x_start-1<M && y_start<N){
      if(map[x_start-1][y_start]==9){
        System.out.println("Yes");
      }else{
        return
      }
    }
    sc.close();
  }

  static Object moveLeft(int[][] map, int x_start, int y_start, int M, int N, int move_x) {
    if((map[x_start-1][y_start]==9 || map[x_start-1][y_start]==1) && x_start-1>0 &&y_start>0 &&x_start-1<M && y_start<N){
      if(map[x_start-1][y_start]==9){
        System.out.println("Yes");
      }else{
        move_x -=1;
      }
    }
    return moveLeft(map, x_start, y_start, M, N, move_x);
  }
  static Object moveRight(int[][] map, int x_start, int y_start, int M, int N) {
    if((map[x_start+1][y_start]==9 || map[x_start+1][y_start]==1) && x_start+1>0 &&y_start>0 &&x_start+1<M && y_start<N){
      if(map[x_start+1][y_start]==9){
        System.out.println("Yes");
      }else{
        
      }
    }
  }
  static Object moveBottom(int[][] map, int x_start, int y_start, int M, int N) {
    if((map[x_start][y_start+1]==9 || map[x_start][y_start+1]==1) && x_start>0 &&y_start+1>0 &&x_start<M && y_start+1<N){
      if(map[x_start][y_start+1]==9){
        System.out.println("Yes");
      }else{
        return moveRight(map, x_start, y_start, M, N);
        
      }
    }
  }
  static Object moveTop(int[][] map, int x_start, int y_start, int M, int N) {
    if((map[x_start][y_start-1]==9 || map[x_start][y_start-1]==1) && x_start>0 &&y_start-1>0 &&x_start<M && y_start+-1<N){
      if(map[x_start][y_start-1]==9){
        System.out.println("Yes");
      }else{
        return moveRight(map, x_start, y_start, M, N);
        
      }
    }
  }
}