package shasha.company.Strings;

public class MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(multiply("31243242535342", "0"));
    }

    private static String multiply(String A, String B) {
        int m = A.length(), n = B.length();
        int num, c = 0, l = 0;
        String result = "";
        for (int i = m - 1; i >= 0; i--) {
            StringBuilder sr = new StringBuilder();
            for (int k = 0; k < l; k++)
                sr.insert(0, 0);
            for (int j = n - 1; j >= 0; j--) {
                int x = A.charAt(i) - '0';
                int y = B.charAt(j) - '0';
                num = (x * y) + c;
                sr.insert(0, num % 10);
                c = num / 10;
            }
            if (c != 0)
                sr.insert(0, c);
            result = add(result, sr.toString());
            l++;
            c = 0;
        }
        StringBuilder sr = new StringBuilder();
        sr.append(result);
        while (sr.length() > 1 && sr.charAt(0) == '0')
            sr.deleteCharAt(0);
        return sr.toString();
    }

    private static String add(String A, String B) {
        int m = A.length(), n = B.length();
        int i = m - 1, j = n - 1, num, c = 0;
        StringBuilder sr = new StringBuilder();
        while (i >= 0 && j >= 0) {
            int x = A.charAt(i) - '0';
            int y = B.charAt(j) - '0';
            num = x + y + c;
            sr.insert(0, num % 10);
            c = num / 10;
            i--;
            j--;
        }
        while (i >= 0) {
            int x = A.charAt(i) - '0';
            num = x + c;
            sr.insert(0, num % 10);
            c = num / 10;
            i--;
        }
        while (j >= 0) {
            int x = B.charAt(j) - '0';
            num = x + c;
            sr.insert(0, num % 10);
            c = num / 10;
            j--;
        }
        if (c != 0)
            sr.insert(0, '1');
        return sr.toString();
    }
}
