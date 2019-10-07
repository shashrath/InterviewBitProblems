package shasha.company.Strings;

public class AddBinaryStrings {

    public static void main(String[] args) {
        System.out.println(addBinary("1110000000010110111010100100111", "101001"));
    }

    private static String addBinary(String A, String B) {
        StringBuilder result = new StringBuilder();
        int n = A.length() - 1;
        int m = B.length() - 1;
        int c = 0;
        while (n >= 0 && m >= 0) {
            int x = Integer.parseInt(String.valueOf(A.charAt(n)));
            int y = Integer.parseInt(String.valueOf(B.charAt(m)));
            if (x + y + c <= 2) {
                int k = (x + y + c) % 2;
                c = (x + y + c) / 2;
                result.insert(0, k);
            } else {
                c = 1;
                result.insert(0, 1);
            }
            n--;
            m--;
        }
        while (n >= 0) {
            int x = Integer.parseInt(String.valueOf(A.charAt(n)));
            int k = (x + c) % 2;
            c = (x + c) / 2;
            result.insert(0, k);
            n--;
        }
        while (m >= 0) {
            int x = Integer.parseInt(String.valueOf(B.charAt(m)));
            int k = (x + c) % 2;
            c = (x + c) / 2;
            result.insert(0, k);
            n--;
        }
        if (c == 1)
            result.insert(0, 1);
        return result.toString();
    }
}
