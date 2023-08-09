import java.util.ArrayList;

class Lab1Coder{
    private String name;
    int experience;
    private ArrayList<String> languages = new ArrayList<>();

    Lab1Coder(){

    }
    Lab1Coder(String n,int exp){
        this.name = n;
        this.experience = exp;
    }
    Lab1Coder(String n){
        this.name = n;
        experience = 0;
    }

    void setName(String name){
        this.name = name;
    }
    String getName(){
        return this.name;
    }
    void setExperience(int exp){
        this.experience = exp;
    }
    int getExperience(){
        return this.experience;
    }
    void setLanguages(String ... lang){
        for(String l : lang){
            this.languages.add(l);
        }
    }
    ArrayList<String> getLanguages(){
        return this.languages;
    }
    public String toString(){
        String str = String.format("%s(%d) knows ",name, experience);
        for(String l : languages){
            str += l + " ";
        }
        return str;
    }
    ArrayList<String> findCommonLanguages(Lab1Coder other){
        ArrayList<String> common = new ArrayList<>();
        for(String l : languages){
            for(String otherl : other.getLanguages()) {
                if(l.equals(otherl)){
                    common.add(l);
                    break;
                }
            }
        }if (common.size() == 0){
            common.add("none");
        }
        return common;
    }
}