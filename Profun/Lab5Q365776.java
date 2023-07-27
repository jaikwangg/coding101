public class Lab5Q365776 {
    public static void main(String[] args) {
        int sum = 0;
        for(int i = 0;i<200;i++){
            //1-199 ยกเว้นหาร10ลงตัว
            if(i %10 != 0){
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
