package shasha.company;

public class ColumnTitle {
    public static void main(String[] args) {
        System.out.println(convertToTitle(702));
    }

    private static String convertToTitle(int A) {
        StringBuilder sr = new StringBuilder();
        while (A > 0) {
            int r = A % 26;
            A = A / 26;
            if (r == 0) {
                sr.append((char) (26 + 64));
                A = A - 1;
            } else {
                char ch = (char) (r + 64);
                sr.append(ch);
            }

        }
        sr.reverse();
        return sr.toString();
    }
}