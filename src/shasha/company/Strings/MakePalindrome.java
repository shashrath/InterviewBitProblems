package shasha.company.Strings;

public class MakePalindrome {
    public static void main(String[] args) {
        System.out.println(makePalindrome("ABC"));
    }

    private static int makePalindrome(String A) {
        int start = 0, end = A.length() - 1;
        isPalindrome(A, start, end);
        int total = 0;
        while (start < end) {
            if (!isPalindrome(A, start, end)) {
                total++;
                end--;
            } else
                return total;

        }
        return total;
    }

    private static boolean isPalindrome(String A, int start, int end) {
        while (start <= end) {
            if (A.charAt(start) == A.charAt(end)) {
                start++;
                end--;
            } else
                return false;
        }
        return true;
    }
}
