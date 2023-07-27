package OOPLab6;

public enum MemberTypeWithDiscount {
    None(0, 0), SILVER(0.5, 0.5),GOLD(1.0, 2.0), PREMIUM(3.0, 4.5);
    private double productDiscountRate;
    private double serviceDiscountRate;

    private MemberTypeWithDiscount(double productDiscountRate,double serviceDiscountRate){
        this.productDiscountRate = productDiscountRate * 10;
        this.serviceDiscountRate = serviceDiscountRate * 10;
    }
    public double getProductDiscount(){ 
        switch (this) {
            case SILVER : return MemberTypeWithDiscount.SILVER.productDiscountRate;
            case GOLD : return MemberTypeWithDiscount.GOLD.productDiscountRate; 
            case PREMIUM : return MemberTypeWithDiscount.PREMIUM.productDiscountRate; 
            default : return MemberTypeWithDiscount.None.productDiscountRate; 
        }
    }
    public double getServiceDiscount(){
        switch (this) {
            case SILVER : return MemberTypeWithDiscount.SILVER.serviceDiscountRate; 
            case GOLD : return MemberTypeWithDiscount.GOLD.serviceDiscountRate; 
            case PREMIUM : return MemberTypeWithDiscount.PREMIUM.serviceDiscountRate; 
            default : return MemberTypeWithDiscount.None.serviceDiscountRate; 
        }
    }
}
