package shasha.company.Strings;

public class PalindromeString {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    private static int isPalindrome(String A) {
        int start = 0, last = A.length() - 1;
        while (start <= last) {
            if (!Character.isLetterOrDigit(A.charAt(start))) {
                start++;
            } else if (!Character.isLetterOrDigit(A.charAt(last))) {
                last--;
            } else {
                if (String.valueOf(A.charAt(start)).equalsIgnoreCase(String.valueOf(A.charAt(last)))) {
                    start++;
                    last--;
                } else
                    return 0;
            }
        }
        return 1;
    }
}
