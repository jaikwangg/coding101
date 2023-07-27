class Lab14 {
    class MyFixedPoint {
        public int data;        
        float getReal() {
            return data;
        }
            
        void adds(MyFixedPoint b) {
            data = data + b.data;
        }
    
        void subtracts(MyFixedPoint b) {
            data = data - b.data;
        }
        void multiplies(MyFixedPoint b) {
            data = data * b.data;
        }
        void divides(MyFixedPoint b) {
            data = data / b.data;
        }
    }
    
    class MyFloatingPoint {
        public float data;
    
        float getReal() {
           return data;
        }
            
        void adds(MyFloatingPoint b) {
            data = data + b.data;
        }
            
        void subtracts(MyFloatingPoint b) {
            data = data - b.data;
        }
            
        void multiplies(MyFloatingPoint b) {
            data = data * b.data;
        }
            
        void divides(MyFloatingPoint b) {
            data = data / b.data;
        }
    
    }
        public static void main(String[] args) {  
            Lab14 l = new Lab14();
            MyFixedPoint fixed1 = l.new MyFixedPoint();
            MyFixedPoint fixed2 = l.new MyFixedPoint();
            MyFloatingPoint floating1 = l.new MyFloatingPoint();
            MyFloatingPoint floating2 = l.new MyFloatingPoint();

            long startFixed = System.nanoTime();
            fixed1.data = 10;
            fixed2.data = 20;
            fixed1.adds(fixed2);
            fixed1.subtracts(fixed2);
            fixed1.multiplies(fixed2);
            fixed1.divides(fixed2);
            fixed1.getReal();
            fixed2.getReal();
            long endFixed = System.nanoTime();
            long timeFixed = endFixed - startFixed;
           
            long startFloating = System.nanoTime();
            floating1.data = 10;
            floating2.data = 20;
            floating1.adds(floating2);
            floating1.subtracts(floating2);
            floating1.multiplies(floating2);
            floating1.divides(floating2);
            floating1.getReal();
            floating2.getReal();
            long endFloating = System.nanoTime();
            long timeFloating = endFloating - startFloating;

            if(timeFixed < timeFloating){
                System.out.println("FixedPoint is faster than FloatingPoint");
            }else{
                System.out.println("FloatingPoint is faster than FixedPoint");
            }
    }
}
