package packA;

public abstract class Employee {
    protected String name;
    protected int experience;
    protected int salary;

    public abstract void sayHi();

    public Employee(){

    }
    public Employee(String name, int experience, int salary){
        this.name = name;
        this.experience = experience;
        this.salary =salary;
    }

    @Override
    public String toString(){
        return String.format("Name : %s  Experience : %d  Salary : %d",name,experience,salary);
    }
}
