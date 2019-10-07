package shasha.company;

import java.util.HashMap;
import java.util.Map;

public class PermutationRankwithRepeat {
    private static final int MOD = 1000003;

    public static void main(String[] args) {
        System.out.println(findRank("sadas"));
    }

    private static int findRank(String a) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = a.length();
        long[] facts = new long[n + 1];
        long[] invFacts = new long[n + 1];
        facts[0] = invFacts[0] = 1;

        for (int i = 1; i <= n; i++) {
            facts[i] = (facts[i - 1] * i) % MOD;
            invFacts[i] = modInv(facts[i], MOD - 2);
        }
        for (int i = 0; i < a.length(); i++) {
            if (map.containsKey(a.charAt(i))) {
                int d = map.get(a.charAt(i));
                map.put(a.charAt(i), ++d);
            } else
                map.put(a.charAt(i), 1);
        }
        long result = 1;
        for (int i = 0; i < a.length(); i++) {
            int count = 0;
            for (Character ch : map.keySet()) {
                if (ch < a.charAt(i)) {
                    count = count + map.get(ch);
                }
            }
            result = result + (count * (facts[n - i - 1])) * factorialdenom(invFacts, map);
            int val = map.get(a.charAt(i));
            if (--val == 0)
                map.remove(a.charAt(i));
            else
                map.put(a.charAt(i), val);
        }
        return (int) (result % 1000003);
    }

    private static long factorialdenom(long[] invFacts, Map<Character, Integer> m) {
        long result = 1;
        for (Map.Entry<Character, Integer> entry : m.entrySet()) {
            if (entry.getValue() > 1)
                result = (result * invFacts[entry.getValue()]) % 1000003;
        }
        return result;
    }

    private static long modInv(long A, long y) {

        long res = 1;

        while (y > 0) {
            if ((y & 1) == 1) {
                res = (res * A) % 1000003;
            }
            A = (A * A) % 1000003;

            y >>= 1;
        }

        return res;
    }
}
