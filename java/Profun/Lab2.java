

public class Lab2 {
    public static void main(String[] args) {
        int []arr = {1,2,2,2,3,3,3,3,3};
        int mem = arr[0];
        int cur = arr[0];
        int maxCnt = Integer.MIN_VALUE;
        int curCnt = 0;
        int mode =arr[0];
        for (int idx=1; idx<arr.length; idx++){
            cur = arr[idx];
            if(cur==mem){
                curCnt++;
            }else{
                if(cur>mem){
                    mode=mem;
                    maxCnt=curCnt;
                }
                mem=cur;
                curCnt=0;
            }
        }
        if(curCnt>maxCnt){
            mode=mem;
            maxCnt=curCnt;
        }
        System.out.printf("mode=%d freq=%d%n" ,mode ,maxCnt);
    }   
}
