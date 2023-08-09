import packA.Lec4Duck;
import packA.Lec4Fish;

public class Lab4q1 {
    public static void main(String[] args) {
        q1();
    }
    public static void q1(){
        Lec4Fish fish = new Lec4Fish();
        fish.swim();
        fish.fishMethod();
        Lec4Duck duck = new Lec4Duck();
        duck.swim();
        duck.duckMethod();
    }
}
