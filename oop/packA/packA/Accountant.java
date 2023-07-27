package packA;

public class Accountant extends Employee {
    private static String companyName = "berk barn jamkad";
    private int experience;
    private String specialty;

    public Accountant(String name, int superExp, int experience, int sal, String talent){
        super();
        this.experience = experience;
        this.specialty = talent;
    }
    public String getSpecialty() {
        return this.specialty;
    }

    public void setSpecialty(String newSpecialty) {
        this.specialty = newSpecialty;
    }
    public int getAccountExperience(){
        return this.experience;
    }
    public void setAccontExperience(int exp){
        experience = exp;
    }
    public String tellProfit(){
        int rd = (int)(Math.random()*1000);
        return String.format("%s's profit is %d. My salary is %d",companyName,rd,salary);
    }
    public String toString(){
        return String.format("Accountant [experience=%d, specialty=%s]",experience,specialty);
    }
    @Override
    public void sayHi(){
        System.out.println("accountant");
    }
    public static String tellMyRole(){
        return String.format("I am an accountant at %s",companyName);
    }
}
