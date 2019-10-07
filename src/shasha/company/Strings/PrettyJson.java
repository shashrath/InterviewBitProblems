package shasha.company.Strings;

import java.util.ArrayList;

public class PrettyJson {
    public static void main(String[] args) {
        String str = "{\"attributes\":[{\"nm\":\"ACCOUNT\",\"lv\":[{\"v\":{\"Id\":null,\"State\":null},\"vt\":\"java.util.Map\",\"cn\":1}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":13585},{\"nm\":\"PROFILE\",\"lv\":[{\"v\":{\"Party\":null,\"Ads\":null},\"vt\":\"java.util.Map\",\"cn\":2}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":41962}]}";
        ArrayList<String> al = new ArrayList<>();
        al = prettyJSON(str);
        for (String s : al)
            System.out.println(s);
    }

    private static ArrayList<String> prettyJSON(String A) {
        ArrayList<String> result = new ArrayList<>();
        if (A.length() == 0)
            return result;
        result.add(String.valueOf(A.charAt(0)));
        int ind = 1, i = 1;
        boolean flag = false;
        StringBuilder sr = new StringBuilder();
        while (i < A.length()) {
            for (int k = 0; k < ind; k++)
                sr.append('\t');
            while (A.charAt(i) != '{' && A.charAt(i) != '}' && A.charAt(i) != '[' && A.charAt(i) != ']' && A.charAt(i) != ',') {
                if (A.charAt(i) == ' ') {
                    i++;
                    continue;
                }
                sr.append(A.charAt(i));
                flag = true;
                i++;
            }
            if (A.charAt(i) == '{' || A.charAt(i) == '[') {
                if (flag)
                    result.add(sr.toString());
                flag = false;
                sr = new StringBuilder();
                for (int k = 0; k < ind; k++)
                    sr.append('\t');
                sr.append(A.charAt(i));
                result.add(sr.toString());
                ind++;
            } else if (A.charAt(i) == ',') {
                sr.append(',');
                result.add(sr.toString());
                flag = false;
            } else if (A.charAt(i) == '}' || A.charAt(i) == ']') {
                if (flag)
                    result.add(sr.toString());
                flag = false;
                sr = new StringBuilder();
                ind--;
                for (int k = 0; k < ind; k++)
                    sr.append('\t');
                sr.append(A.charAt(i));
                if (i + 1 < A.length() && A.charAt(i + 1) == ',') {
                    i++;
                    sr.append(',');
                }
                result.add(sr.toString());
            }
            sr = new StringBuilder();
            i++;
        }
        return result;
    }
}
