import java.util.*;

public class MyArrDemo<T> {
    public final int MAX_SIZE = 9;
    private int size = 0;
    private Object[] arr = new Object[MAX_SIZE];

    public void add(T instance) {
        arr[size++] = instance;
    }

    public void set(int i, T instance) {
        arr[i] = instance;
    }

    public T get(int i) {
        @SuppressWarnings("unchecked")
        final T element = (T) arr[i];
        return element;
    }

    public void swap(int i, int j) {
        if (i >= 0 && i < size && j >= 0 && j < size) {
            Object temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public void selectionSort() {
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (((SillyLuckyNumber) get(j)).getLuckyNumber() < ((SillyLuckyNumber) get(minIndex)).getLuckyNumber()) {
                    minIndex = j;
                }
            }
            swap(i, minIndex);
        }
    }

    public int currentSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("My snapshot looks like this -> ");
        for (int i = 0; i < size; i++)
            sb.append(arr[i] + ",");
        return sb.toString();
    }

    public static void main(String[] args) {
        demo1();
        demo2();
        demo3();
        demo4();
        demo5();
    }

    static void demo1() {
        System.out.println("-demo1---");
        SillyLuckyNumber[] arr = {
            new SillyLuckyNumber("Terrier"), 
            new SillyLuckyNumber("Jack"),
            new SillyLuckyNumber("Pom"), 
            new SillyLuckyNumber("Beagle")
        };
        System.out.println(Arrays.toString(arr));
    
        Comparator<SillyLuckyNumber> engine = (a, b) -> Integer.compare(a.getLuckyNumber(), b.getLuckyNumber());
        Arrays.sort(arr, engine);
        
        System.out.println(Arrays.toString(arr));
    }
    

    static void demo2() {
        System.out.println("-demo2----");
        ArrayList<SillyLuckyNumber> list = new ArrayList<>(Arrays.asList(
            new SillyLuckyNumber("Terrier"), 
            new SillyLuckyNumber("Jack"),
            new SillyLuckyNumber("Pom"), 
            new SillyLuckyNumber("Beagle")
        ));
        System.out.println(list);
        
        Collections.sort(list, Comparator.comparing(SillyLuckyNumber::getLuckyNumber));
        
        System.out.println(list);
    }

    static void demo3() {
        System.out.println("-demo3----");
        ArrayList<SillyLuckyNumber> list = new ArrayList<>(Arrays.asList(
            new SillyLuckyNumber("Terrier"), 
            new SillyLuckyNumber("Jack"),
            new SillyLuckyNumber("Pom"), 
            new SillyLuckyNumber("Beagle")
        ));
        
        System.out.println(list);
        list.sort(Comparator.comparing(SillyLuckyNumber::getLuckyNumber));       
        System.out.println(list);
        // demo shallow copy
        ArrayList<SillyLuckyNumber> anotherList = new ArrayList<>(list.subList(0, list.size()));
        anotherList.get(0).setBreed("newBreed"); //Terrier
        System.out.println(list);
    }

    static void demo4() {
        System.out.println("-demo4----");
        MyArrDemo<SillyLuckyNumber> arr = new MyArrDemo<>();
        arr.add(new SillyLuckyNumber("Terrier"));
        arr.add(new SillyLuckyNumber("Jack"));
        arr.add(new SillyLuckyNumber("Pom"));
        arr.add(new SillyLuckyNumber("Beagle"));
        System.out.println(arr);

        arr.swap(1, 3);

        System.out.println(arr);
    }

    static void demo5() {
        System.out.println("-demo5----");
        MyArrDemo<SillyLuckyNumber> arr = new MyArrDemo<>();
        arr.add(new SillyLuckyNumber("Terrier"));
        arr.add(new SillyLuckyNumber("Jack"));
        arr.add(new SillyLuckyNumber("Pom"));
        arr.add(new SillyLuckyNumber("Beagle"));
        arr.add(new SillyLuckyNumber("Cocker Spaniel"));
        arr.add(new SillyLuckyNumber("Basenji"));
        System.out.println(arr);
        
        arr.selectionSort();
        
        System.out.println(arr);
    }
}

class SillyLuckyNumber {
    private String breed;
    private int luckyNumber;
    private int threeDigit; // 0 to 999

    public SillyLuckyNumber(String s) {
        breed = s;
        for (int i = 0; i < breed.length(); i++)
            luckyNumber += breed.charAt(i);
        threeDigit = luckyNumber % 1000;
    }

    // getters
    public int getLuckyNumber() {
        return luckyNumber;
    }
    
    public void setBreed(String b) {
        breed = b;
        luckyNumber = 0;
        for (int i = 0; i < breed.length(); i++) {
            luckyNumber += breed.charAt(i);
        }
        threeDigit = luckyNumber % 1000;
    }

    @Override
    public String toString() {
        return "<<" + breed + " " + luckyNumber + " " + threeDigit + ">>";
    }
}
