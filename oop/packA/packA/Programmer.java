package packA;

import java.util.ArrayList;
import java.util.Arrays;

public class Programmer extends Employee {
    private ArrayList<String> skill;

    public Programmer() {

    }

    public Programmer(String name, int experience, int salary) {
        super(name, experience, salary);
        skill = new ArrayList<String>(Arrays.asList("Solidity","TypeScript"));
    }

    public Programmer(String name, int experience, int salary, String... skill) {
        super(name, experience, salary);
        this.skill = new ArrayList<String>(Arrays.asList(skill));
    }

    @Override
    public void sayHi() {
        System.out.println("SayHi from Programmer");
    }

    public String coding() {
        return "Coding";
    }

    public void setName(String name) {
        super.name = name;
    }

    public String getName() {
        return super.name;
    }

    public void setSalary(int salary) {
        super.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSkill(String... skill) {
        this.skill = new ArrayList<String>(Arrays.asList(skill));
    }

    public ArrayList<String> getSkill() {
        return skill;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSkill : " + skill;
    }
}