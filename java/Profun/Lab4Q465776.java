public class Lab4Q465776 {
    public static void main(String[] args) {
        //perfect num = ผลรมของตปกเท่ากับตัวมันเอง 
        int sum = 0;
        for(int i = 1; i<1000; i++){
            for(int j = 1; j <= i/2;j++){
                if(i%j == 0){
                    sum +=j;
                }
            }
            if(sum==i){
                System.out.println(sum);
            }
            sum=0;
        }
    }
}
