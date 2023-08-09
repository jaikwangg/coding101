public class Lab8 {
    public static void main(String[] args) {
        q1_halfEachNumber();
    }

    public static void q1_halfEachNumber() {
        List<Integer> nums = Arrays.asList(100, 105);
        HalfValueInterface halfVal = n -> System.out.println(n / 2);
        for (int n : nums) {
        halfVal.printHalf(n);
        }
        Consumer<Integer> consumer = n -> System.out.println(n);
        for (int n : nums) {
        consumer.accept(n);
        }
        Consumer<Integer> halfMe = n ->
         System.out.println(n / 2);
        nums.forEach(consumer);;
        nums.forEach(halfMe);
        NumberProcessor np = new NumberProcessor();
        nums.forEach(np::process);
        }
}
