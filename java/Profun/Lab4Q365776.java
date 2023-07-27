public class Lab4Q365776 {
    public static void main(String ... args) {
        int amountCharge = 0;
        int hrsPark = 0;
        for (int i = 0; i < args.length; i++) {
            hrsPark = Integer.parseInt(args[i]);
            //your code
            amountCharge = 0;
            while(hrsPark > 0){
            
            if(hrsPark >= 18||hrsPark == 24){
                amountCharge += 24;
                hrsPark -= 24;
            }
            else if(hrsPark >=5){
                amountCharge += 1;
                hrsPark -= 1;
            }
            else if(hrsPark >=3){
                amountCharge += 3;
                hrsPark -= 1;
            }
            else if(hrsPark >=0){
                amountCharge += 4;
                hrsPark -= 2;
            }
            }
            System.out.println(amountCharge);
        } //4 7 10 11 24 24 127 
    }    
}
