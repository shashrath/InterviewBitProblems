package shasha.company.BitManipulation;

public class DivideIntegers {
    public static void main(String[] args) {
        System.out.println(divide(-2147483648, 1));
    }

    private static int divide(int A, int B) {
        if (B == 0)
            return Integer.MAX_VALUE;
        if (A == 0)
            return 0;
        boolean b = false;
        if (A < 0 || B < 0) {
            if ((A < 0 && B > 0) || (A > 0 && B < 0))
                b = true;
        }
        if (B == Integer.MIN_VALUE) {
            if (A == Integer.MIN_VALUE)
                return 1;
            else
                return 0;
        }
        int i = 0;
        if (A == Integer.MIN_VALUE) {
            if (B == 1 || B == -1)
                return Integer.MAX_VALUE;
            else {
                if (b)
                    A = A + B;
                else
                    A = A - B;

                i++;
            }
        }
        long c = Math.abs(A);
        long d = Math.abs(B);
        while (c - d >= 0) {
            c = c - d;
            i++;
            if (i == Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
        }
        if (b)
            return i * -1;
        else
            return i;
    }
}
