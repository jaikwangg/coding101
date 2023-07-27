import java.util.ArrayList;

public class Lab1Driver {
    static Lab1Coder Somsri;
    static Lab1Coder Keng;
    public static void main(String[] args) {
        q1();
        q2();
        q3();
    }
    
    static void q1(){
        Lab1Coder santa = new Lab1Coder();
        santa.setName("Santa");
        santa.setExperience(3);
        String str = String.format("%s has been working for %d years.",santa.getName(),santa.getExperience());
        System.out.println(str);
    }
    
    static void q2(){
        Somsri = new Lab1Coder("Somsri", 5);
        Somsri.setLanguages("javascript","dart");
        System.out.println(Somsri.getLanguages());
    }
    static void q3(){
        Keng = new Lab1Coder("Keng", 2);
        Keng.setLanguages("java","solidity","c");

        Lab1Coder ber3 = new Lab1Coder("ber3");
        ber3.setLanguages("c","java","typescript");
        System.out.println(ber3);

        ArrayList<String> commonLangauges = ber3.findCommonLanguages(Somsri);
        System.out.println(commonLangauges);
        commonLangauges = Keng.findCommonLanguages(ber3);
        System.out.println(commonLangauges);
    }
}
