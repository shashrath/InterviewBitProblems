package shasha.company.Strings;

public class StrStr {
    public static void main(String[] args) {
        System.out.println(strStr("lstark", "star"));
    }

    private static int strStr(final String A, final String B) {
        int n = A.length(), m = B.length();
        if (m > n)
            return -1;
        if (A.isEmpty() || B.isEmpty())
            return -1;
        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            int k = i;
            while (k < n && j < m && A.charAt(k) == B.charAt(j)) {
                j++;
                k++;
            }
            if (j == m)
                return i;
        }
        return -1;
    }
}
