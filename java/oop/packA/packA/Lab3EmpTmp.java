package packA;

public class Lab3EmpTmp {
    protected String name;
    protected int salary;
    protected int experience;

    public Lab3EmpTmp(String n, int exp, int sal){
        this.name = n;
        this.experience = exp;
        this.salary = sal;
    }
    public Lab3EmpTmp(String n){

    }
    public Lab3EmpTmp(){

    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int newSalary) {
        this.salary = newSalary;
    }
    public int getExperience() {
        return experience;
    }
    public void setExperience(int exp) {
        this.experience = exp;
    }
    public String toString(){
        return String.format("Love");
    }
    
    public void sayHi(){
        
    }
}
