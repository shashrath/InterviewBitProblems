package shasha.company;

import java.util.HashSet;
import java.util.Set;

public class PermutationRank {
    public static void main(String[] args) {
        System.out.println(findRank("qwertyuiopasdfghjklzxcvbnm"));
    }

    private static int findRank(String a) {
        Set<Character> s = new HashSet<>();
        int n = a.length();
        for (int i = 0; i < a.length(); i++) {
            s.add(a.charAt(i));
        }
        long result = 1;
        for (int i = 0; i < a.length(); i++) {
            int count = 0;
            for (Character ch : s) {
                if (ch < a.charAt(i))
                    count++;
            }
            result = result + count * ((factorial(n - i - 1)));
            s.remove(a.charAt(i));
        }
        return (int) (result % 1000003);
    }

    private static long factorial(int n) {
        long result = 1;
        while (n > 0) {
            result = (result * n) % 1000003;
            n--;
        }
        return result;
    }
}
