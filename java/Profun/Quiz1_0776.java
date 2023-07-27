import java.util.Arrays;
import java.util.Scanner;

public class Quiz1_0776{
  public static void main(String [] agrs){
    Scanner sc = new Scanner(System.in);
    System.out.print("Input Row & Column : ");
    String RC = sc.nextLine();
    String [] RowColumn = RC.split(" ");
    int Row = Integer.parseInt(RowColumn[0]);
    int Column = Integer.parseInt(RowColumn[1]);
    int [][] BOX = new int[Row][Column];

    int i = 0;
    System.out.println("Input Data : ");
    while(i < Row){
      String  data = sc.nextLine();
      String [] DATA = data.split(" ");
      for(int j = 0; j < Row; j++){

          BOX[i][j] = Integer.parseInt(DATA[j]);
      }
      i++;
   }//while

    System.out.println(Arrays.deepToString(BOX));
    sc.close();
  }//main

}//class