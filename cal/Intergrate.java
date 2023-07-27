class Integrate {
    static final int LEFT_POINT = 0;
    static final int MID_POINT = 1;
    static final int RIGHT_POINT = 2;

    public interface FofX {
        double eval(double x);
    }

    static double integrate(FofX f, double a, double b, int interval, int point) {
        double sum = 0;
        double dx = (b - a) / interval;
        for(int i = 0; i < interval; i++) {
            double x;
            switch(point) {
                case LEFT_POINT:
                    x = a + i * dx;
                    break;
                case MID_POINT:
                    x = a + (i + 0.5) * dx;
                    break;
                case RIGHT_POINT:
                    x = a + (i + 1) * dx;
                    break;
                default:
                    return Double.NaN;
            }
            sum += f.eval(x) * dx;
        }
        return sum;
    }

    public static void main(String args[]) {
        int interval = 1;
        while (true) {
            interval *= 2;
            double s = integrate(x -> x * x, 0, 1, interval, LEFT_POINT);
            double s2 = integrate(x -> x * x, 0, 1, interval, MID_POINT);

            double[] sumAB = {s, s2};
            System.out.println("******************");
            for (int j = 0; j < sumAB.length; j++) {
                double deltaError = Math.abs(sumAB[j] - 1.0 / 3.0);
                String name = (j == 0) ? "sum1" : "sum2";
                System.out.format("TYPE OF INTEGRATION : %s\n", name);
                System.out.format("∂E = %f\n", deltaError);
                System.out.format("%s = %f\n", name, sumAB[j]);

                if (deltaError > 0.001) {
                    System.out.println("Error is too much");
                } else {
                    System.out.println("Accepted the little error");
                    if (j == 0) {
                        System.out.println(interval);
                    }
                }
                System.out.println("--------------");
            }
        }
    }
}
