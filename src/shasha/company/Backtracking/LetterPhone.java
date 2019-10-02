package shasha.company.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class LetterPhone {
    private ArrayList<String> keypad;
    private ArrayList<String> result;

    public static void main(String[] args) {
        LetterPhone letterPhone = new LetterPhone();
        letterPhone.letterCombinations("24");
        letterPhone.printSolution();
    }

    private void printSolution() {
        for (String s : result)
            System.out.println(s + " ");
    }

    private void letterCombinations(String A) {
        result = new ArrayList<>();
        keypad = new ArrayList<>(Arrays.asList("0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"));
        solUtil(result, A, 0, new StringBuilder());
    }

    private void solUtil(ArrayList<String> result, String a, int pos, StringBuilder sb) {
        if (pos == a.length())
            result.add(sb.toString());
        else {
            String str = keypad.get(a.charAt(pos) - '0');
            for (int i = 0; i < str.length(); i++) {
                sb.append(str.charAt(i));
                solUtil(result, a, pos + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
