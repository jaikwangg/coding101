package packA;

public class Salesperson extends Employee implements SalesRoles{
    private int target;
    
    public Salesperson(){

    }
    public Salesperson(String n, int exp,int sal,int assignedTarget){
        super(n, exp, sal);
        this.target = assignedTarget;
    }
    public Salesperson(String n, int exp){
        
    }
    public int getTarget() {
        return target;
    }
    public void setTarget(int target) {
        this.target = target;
    }
    public void setSalary(){
        super.salary = 100;
    }
    public void setSalary(int incresedAmount){
        super.salary += incresedAmount;
    }
    public String makeQuotation(){
        return "From Quotation";
    }
    @Override
    public void sayHi() {
        System.out.println("sayHi from SalePerson");
    }
}
