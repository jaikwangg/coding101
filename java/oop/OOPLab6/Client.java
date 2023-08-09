package OOPLab6;

public class Client implements CanPay{
    private String name;
    private MemberTypeWithDiscount memberType;

    public Client(String name){
        this.name = name;
        memberType = MemberTypeWithDiscount.None;
    }
    private void promoteMemberType(){
        switch (memberType) {
            case None : memberType = MemberTypeWithDiscount.SILVER; break;
            case SILVER : memberType = MemberTypeWithDiscount.GOLD; break;
            case GOLD : memberType = MemberTypeWithDiscount.PREMIUM; break;
            case PREMIUM : break;
        }
    }
    private void demoteMemberType(){
        switch (memberType) {
            case None : break;
            case SILVER :  break;
            case GOLD : memberType = MemberTypeWithDiscount.SILVER; break;
            case PREMIUM : memberType = MemberTypeWithDiscount.GOLD; break;
        }
    }
    public void showMembershipStatus(){
        System.out.println("You are now " + memberType.name() + memberType.getProductDiscount()+"%discount on Product "+memberType.getServiceDiscount()+"% on service");
    }
    @Override
    public void spend(int direction) {
        if(direction>0){
            promoteMemberType();
            showMembershipStatus();
        }else{
            demoteMemberType();
            showMembershipStatus();
        }
    }
}
