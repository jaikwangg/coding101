public class Lab5Q4_165776 {
    public static void main(String[] args) {
        String str = "WWWWMMMMWMWMWMWMMMWWWWWM" ;
        //นับชายหญิง
        int W = 0;
        int M = 0;
        for(int i =0; i<str.length(); i++){
            if(str.charAt(i)=='W'){
                W ++;
            }
            if(str.charAt(i)=='M'){
                M ++;
            }
        }
        System.out.println("W = "+W);
        System.out.println("M = "+M);
    }

}
