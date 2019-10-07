package shasha.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ShortestSubstring {
    public static void main(String[] args) {
        HashSet<Character> al = new HashSet<>();
        al.add('a');
        al.add('e');
        al.add('i');
        myfunction("figehaeci", al);
    }

    private static void myfunction(String str, HashSet<Character> st) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character ch : st) {
            map.put(ch, 0);
        }
        boolean flag = false;
        int start = 0, end = 0, maxLength = 0, fstart, fend;
        for (int i = 0; i < str.length(); i++) {

            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
                end++;
                if (checkMap(map)) {
                    if (end - start < maxLength) {
                        maxLength = end - start;
                        fstart = start;
                        fend = end;
                    }
                }
            } else {
                end++;
            }


        }
    }

    private static boolean checkMap(HashMap<Character, Integer> m) {
        for (Map.Entry<Character, Integer> entry : m.entrySet()) {
            if (entry.getValue() < 1)
                return false;
        }
        return true;
    }
}
