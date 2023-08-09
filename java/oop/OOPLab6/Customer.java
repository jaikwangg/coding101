package OOPLab6;

public class Customer implements CanPay{
    private String name; 
    private MemberType memberType;

    public Customer(String string) {
        this.name = string;
        memberType = MemberType.None;
    }
    private void promoteMembertype(){
        switch (memberType) {
            case None : memberType = MemberType.SILVER; break;
            case SILVER : memberType = MemberType.GOLD; break;
            case GOLD : memberType = MemberType.PREMIUM; break;
            case PREMIUM : break;
        }

    }
    private void demoteMemberTypr(){
        switch (memberType) {
            case None : break;
            case SILVER : break;
            case GOLD : memberType = MemberType.SILVER; break;
            case PREMIUM : memberType = MemberType.GOLD; break;
        }
    }
    public void showMembershipStatus(){
        System.out.println("You ara now "+memberType.name());
    }
    @Override
    public void spend(int direction) {
        if(direction>0){
            promoteMembertype();
            showMembershipStatus();
        }
        else{
            demoteMemberTypr();
            showMembershipStatus();
        }
    }
}
