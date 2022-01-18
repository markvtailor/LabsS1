public class PolyCalculator {

    public static double calculatePolynom(double[] digits) {

        double polyn = 0;

        for (double digit : digits) {
            double x;
            x = digit;
            if (x > 0) {
                polyn += ((1/x)*27);
            }
        }
        System.out.println(polyn);
        return polyn;
    }
}
