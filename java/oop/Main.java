import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import java.util.Collections;

public class Main{
    public static void main(String[] args) {
        System.out.println("\nQ1");
        q1_halfEachNumber();
        System.out.println("\nQ2");
        q2_forEachSingerName();
        System.out.println("\nQ3");
        q3_lambda_comparator();
        System.out.println("\nQ4");
        q4_method_refference_comparator();
    }
    public static void q1_halfEachNumber(){
        System.out.println("\tQ1.1");
        List<Integer> nums = Arrays.asList(100, 105);
        HalfValueInterface halfVal = (n) -> {
            System.out.println(n/2);
        };       
        for(int n : nums){
            halfVal.printHalf(n);
        }

        System.out.println("\tQ1.2");
        Consumer<Integer> Consumer = n -> {
            System.out.println(n/2);
        };
        for(int n : nums){
            Consumer.accept(n);
        }

        System.out.println("\tQ1.3");
        Consumer<Integer> halfMe = n -> {
            System.out.println(n / 2);
        };
        nums.forEach(halfMe);

        System.out.println("\tQ1.4");
        nums.forEach(n -> {System.out.println(n/2);});

        System.out.println("\tQ1.5");
        NumberProcessor np = new NumberProcessor();
        nums.forEach(np::printHalf);
    }
    public static void q2_forEachSingerName(){
        List<Singer> singerList = Arrays.asList(new Singer("Aba", Singer.SingerStyle.POP), new Singer("Abo", Singer.SingerStyle.POP), new Singer("Abi", Singer.SingerStyle.ROCK), new Singer("Abe", Singer.SingerStyle.ROCK));
        
        System.out.println("\tQ2.1");
        singerList.stream().map(Singer::getName).forEach(System.out::println);
        
        System.out.println("\tQ2.2");
        singerList.stream().map((s) -> s.getName()).forEach(System.out::println);
    }
    public static void q3_lambda_comparator(){
        List<Singer> singerList = Arrays.asList(new Singer("Aba", Singer.SingerStyle.POP), new Singer("Abo", Singer.SingerStyle.POP), new Singer("Abi", Singer.SingerStyle.ROCK), new Singer("Abe", Singer.SingerStyle.ROCK));
        Comparator<Singer> byStyle1 = new Comparator<Singer>() {
            @Override
            public int compare(Singer o1, Singer o2) {
                return o1.getStyle().compareTo(o2.getStyle());
            }
        };
        Collections.sort(singerList, byStyle1);
        singerList.forEach(System.out::println);

        System.out.println("\tQ3.1");
        Comparator<Singer> byStyle2 = (o1, o2) -> o1.getName().compareTo(o2.getName());
        Collections.sort(singerList, byStyle2);
        singerList.forEach(System.out::println);
    }
    public static void q4_method_refference_comparator(){
        
        System.out.println("\tQ4.1");
        List<Singer> singerList = Arrays.asList(new Singer("Aba", Singer.SingerStyle.POP), new Singer("Abo", Singer.SingerStyle.POP), new Singer("Abi", Singer.SingerStyle.ROCK), new Singer("Abe", Singer.SingerStyle.ROCK));
        Comparator<Singer> byName = Comparator.comparing(Singer::getName);
        Collections.sort(singerList, byName);
        singerList.forEach(System.out::println);
        System.out.println("--------");
        
        System.out.println("\tQ4.2");
        singerList.sort((o1, o2) -> o1.getStyle().compareTo(o2.getStyle()));
        singerList.forEach(System.out::println);
    }
}
interface HalfValueInterface{
    public void printHalf(int n);
}
class NumberProcessor{
    public void printHalf(int n){
        System.out.println(n/2);
    }
}
class Singer{
    private String name;
    private SingerStyle style;
    public enum SingerStyle {
        POP,
        ROCK
    };
    public Singer(String name, SingerStyle style){
        this.name = name;
        this.style = style;
    }
    public String getName() {
        return name;
    }
    public SingerStyle getStyle(){
        return style;
    }
    @Override
    public String toString() {
        return String.format("Singer (%s-%s)", name, style);
    }
} {
    
}
