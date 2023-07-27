import java.util.Scanner;

public class discrete{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //input
        System.out.print("Vertex : ");
        int vertex = sc.nextInt();
        System.out.print("Edge : ");
        int edge = sc.nextInt();
        int[] arrayVertex = new int[vertex+1];
        for(int i = 0 ;i<edge ;i++){
            System.out.println("Edge : e"+(i+1));
            System.out.print("Start : ");
            int Start = sc.nextInt();
            arrayVertex[Start-1]++;
            System.out.print("End : ");
            int End = sc.nextInt();
            arrayVertex[End-1]++;
        }
        System.out.println();
        //output
        for(int i =0 ;i<vertex ;i++){
            System.out.println("Edge in Vertex v"+(i+1)+" : "+arrayVertex[i]);
        }
        sc.close();
    }
}