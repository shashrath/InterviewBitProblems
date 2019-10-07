package shasha.company;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }

    private static int reverse(int A) {
        boolean flag = false;
        if (A < 0)
            flag = true;
        long temp = Math.abs((long) A);

        StringBuilder sr = new StringBuilder();
        while (temp > 0) {
            sr.append(temp % 10);
            temp = temp / 10;
        }
        long n = Long.parseLong(sr.toString());
        if (n > Integer.MAX_VALUE)
            return 0;
        if (flag)
            return (int) -n;
        else
            return (int) n;
    }
}
