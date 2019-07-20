package shasha.company.BitManipulation;

public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(reverse(3));
        //printBinary(3);
    }

    private static long reverse(long n) {
        long res = 0;
        for (int i = 0; i < 32; i++) {
            printBinary(res);
            if ((n & (1 << i)) != 0) {
                long temp = (1 << (31 - i));
                res = (res | (temp));
            }
        }
        return res;
    }

    private static long dusra(long n) {
        long res = 0;
        for (int i = 0; i < 32; i++) {
            printBinary(res);
            res |= ((n >> i) & 1) << (31 - i);
        }
        return res;
    }

    private static void printBinary(long n) {
        long res = 0;
        for (int i = 63; i >= 0; i--) {
            if ((n & (1 << i)) != 0)
                System.out.print(1);
            else
                System.out.print(0);
        }
        System.out.println();
    }

}

