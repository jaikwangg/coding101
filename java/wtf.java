public class wtf {
    public static void main(String args[]) {
        for(int N=10000000; N<=100000000; N+=10000000) {
        long start = System.currentTimeMillis();
        MyArray mArray = new MyArray();
        for(int n=1; n<N; n++) {
        mArray.add((int)(Math.random()*1000));
        }
        long time = (System.currentTimeMillis()-start);
        System.out.println(N+" \t"+time);
        }
        }
}
