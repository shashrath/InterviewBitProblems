package shasha.company.Strings;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>(Arrays.asList(""));
        System.out.println(longestCommonPrefix(al));
    }

    private static String longestCommonPrefix(ArrayList<String> A) {
        int minLen = Integer.MAX_VALUE;
        for (String str : A) {
            if (str.length() < minLen)
                minLen = str.length();
        }
        StringBuilder sr = new StringBuilder();
        for (int i = 0; i < minLen; i++) {
            Character ch = A.get(0).charAt(i);
            int j = 1;
            while (j < A.size() && A.get(j).charAt(i) == ch) {
                j++;
            }
            if (j == A.size()) {
                sr.append(ch);
            } else
                break;
        }
        return sr.toString();
    }
}