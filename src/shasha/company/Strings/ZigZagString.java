package shasha.company.Strings;

public class ZigZagString {
    public static void main(String[] args) {
        System.out.println(convert("paypalishiring", 2));
    }

    private static String convert(String A, int B) {
        if (B <= 1)
            return A;
        int udiff = 0, ddiff = 0;
        boolean down;
        StringBuilder sr = new StringBuilder();
        for (int i = 1; i <= B; i++) {
            ddiff = Math.abs(B - i) * 2;
            udiff = Math.abs(1 - i) * 2;
            if (ddiff < 1)
                down = false;
            else
                down = true;
            int j = i - 1;
            while (j < A.length()) {
                if (ddiff > 0 && down) {
                    sr.append(A.charAt(j));
                    j = j + ddiff;
                }
                if (udiff > 0 && !down) {
                    sr.append(A.charAt(j));
                    j = j + udiff;
                }
                down = !down;
            }
        }
        return sr.toString();
    }
}
