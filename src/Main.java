import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class Main {
    public static final MathContext context = new MathContext(512);

    public static void main (String[] args) {
        System.out.println(BinarySearch(256, 512).toString());
    }

    public static BigDecimal BinarySearch (int depth, int sinDepth) {
        BigDecimal min = new BigDecimal(3);
        BigDecimal max = new BigDecimal(4);

        BigDecimal middle = min.add(max).divide(new BigDecimal(2), context);

        for (int i = 0; i < depth; i++) {
            int c = getSin(middle, sinDepth).compareTo(new BigDecimal(0));
            if (c < 0) max = middle;
            else if (c > 0) min = middle;
            else return middle;

            middle = min.add(max).divide(new BigDecimal(2), context);

            System.out.println(i + ": " + middle);
        }

        return middle;
    }

    public static BigDecimal getSin (BigDecimal x, int depth) {
        BigDecimal sum = new BigDecimal(0);
        for (int n = 0; n < depth; n++) {
            BigDecimal numerator = x.pow(2 * n + 1).multiply(BigDecimal.valueOf(Math.pow(-1, n)));
            BigDecimal denominator = new BigDecimal(factorial(2 * n + 1));
            BigDecimal r = numerator.divide(denominator, context);

            sum = sum.add(r);
        }
        return sum;
    }

    public static BigInteger factorial (int n) {
        BigInteger output = BigInteger.valueOf(1);
        for (int i = 2; i < n + 1; i++) {
            output = output.multiply(BigInteger.valueOf(i));
        }
        return output;
    }
}
