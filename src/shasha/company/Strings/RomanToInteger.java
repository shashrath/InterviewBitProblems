package shasha.company.Strings;

import java.util.HashMap;

public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("XIV"));
    }

    private static int romanToInt(String A) {
        HashMap<String, Integer> h = new HashMap<>();
        createMap(h);
        int val = 0;
        int i = 0;
        while (i < A.length()) {

            StringBuilder sr = new StringBuilder();
            sr.append(A.charAt(i));
            if (i + 1 < A.length()) {
                sr.append(A.charAt(i + 1));
                if (h.containsKey(sr.toString())) {
                    val = val + h.get(sr.toString());
                    i = i + 2;
                } else {
                    sr.deleteCharAt(1);
                    val = val + h.get(sr.toString());
                    i++;
                }

            } else {
                val = val + h.get(sr.toString());
                i++;
            }
        }
        return val;
    }

    private static void createMap(HashMap<String, Integer> h) {
        h.put("I", 1);
        h.put("IV", 4);
        h.put("V", 5);
        h.put("IX", 9);
        h.put("X", 10);
        h.put("XL", 40);
        h.put("L", 50);
        h.put("XC", 90);
        h.put("C", 100);
        h.put("CD", 400);
        h.put("D", 500);
        h.put("CM", 900);
        h.put("M", 1000);
    }
}
