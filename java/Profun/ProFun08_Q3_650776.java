import java.util.*;
public class ProFun08_Q3_650776 {
    public static void main(String[] args) {
        int [] intArr = {0,0,0,0,0,0,0,0,0,0};
        topK(intArr);
    }
    static void topK(int [] intArr){
        int a = 0;
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("Input : ");
            int n = sc.nextInt();
            if(n<=0)
                break;
            intArr[9]= n;
                for (int i = 0; i < intArr.length; i++){  
                    for (int j = i + 1; j < intArr.length; j++){  
                    if (intArr[i] < intArr[j]){  
                        a = intArr[i];  
                        intArr[i] = intArr[j];  
                        intArr[j] = a;  
                        } 
                    } 
                }
            System.out.println("Output : "+Arrays.toString(intArr));
        }
        System.out.println("<Program Terminated>");
        sc.close();
    }
}
