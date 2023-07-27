class Lab3Q350776{
    public static void main(String[] args) {
        int x = 0;
        for (int k=0;k<1000;k++){
            if (k%3==0 || k%5==0){
                x=x+k;
            }
        }
        System.out.println(x);
    }
}