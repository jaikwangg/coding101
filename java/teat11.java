import java.util.Scanner;
public class teat11{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt();
    int n = sc.nextInt();
    String[] reach ={"No"};
    int[][] a = new int[n][m];
    int[][] visited = new int[a.length][a[0].length];
    for (int i = 0; i < n ;i++){
      for(int j = 0;j < m;j++){
         a[i][j] = sc.nextInt();
      }
    }sc.close();
    int[] startPoint = checkStart(a);
    findExit(a,startPoint[0],startPoint[1],visited,reach);
    System.out.println(reach[0]);
  }
  static int[] checkStart(int[][] map){
        for (int i = 0; i < map.length; i++) 
            for (int j = 0; j < map[i].length; j++) 
                if(map[i][j] == -1)
                    return new int[] {i,j};
        return new int[]{-1,-1};
    }
    static void findExit(int[][] map,int row,int col,int[][] visited,String[] reach){
        if(reach[0] != "Yes"){
            visited[row][col] = 1;
            if(map[row][col] == 9){
                reach[0] = "Yes";
                return;
            }
            else{
                if(row+1 < map.length && visited[row+1][col] != 1 && map[row+1][col] != 0)
                    findExit(map, row+1, col, visited,reach); //up
                if(row-1 >= 0 && visited[row-1][col] != 1 && map[row-1][col] != 0)
                    findExit(map, row-1, col, visited,reach); //down
                if(col-1 >= 0 && visited[row][col-1] != 1 && map[row][col-1] != 0)
                    findExit(map, row, col-1, visited,reach); //left
                if(col+1 < map[row].length && visited[row][col+1] != 1 && map[row][col+1] != 0)
                    findExit(map, row, col+1, visited,reach); //rigth
                return;
            }
        }
    }
}