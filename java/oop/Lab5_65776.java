package oop;

import java.util.Arrays;

public class Lab5_65776 {
    static int[] data = { 28, 58, 8, 77, 48, 39 };
    static ArrayProcessor q1NumberOfEvenElement; // 4
    static ArrayProcessor q2IndexOfLargestEvenValue; // 1
    static ArrayProcessor myMedian; // n/2th element of sorted = 48
    public static void main(String[] args) {
        q1(); // 4
        q2(); // 1
        oneline(); // 48
    }
    static void q1(){
        q1NumberOfEvenElement = (data) -> {
            int count = 0 ;
            for(int i = 0 ; i < data.length ; i++ ){
                if (data[i]%2==0) count++;
            }
            return count;
        };
        System.out.println(q1NumberOfEvenElement.calculate(data));
    }

    static void q2(){
        q2IndexOfLargestEvenValue = (data) -> {
            int max = Integer.MIN_VALUE;
            int j = 0;
            for(int i = 0 ; i < data.length ; i++ ){
                if(data[i]%2==0 && data[i]>max){
                    max = data[i];
                    j = i;
                }
            }
            return j;
        };
        System.out.println(q2IndexOfLargestEvenValue.calculate(data));
    }

    static void oneline() {
        int[] tmp = Arrays.copyOf(data, data.length);
        Arrays.sort(tmp);
        myMedian = (data) -> tmp[tmp.length/2];
        System.out.println(myMedian.calculate(tmp)); // 77
    }
}
