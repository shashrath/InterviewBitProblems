package shasha.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class tokenization {
    public static void main(String[] args) {
        String s = "pool_fridge_wifi";
        String str ="";
        if(!str.isEmpty())
            System.out.println("yaahooo");
        ArrayList<String> al = new ArrayList<>(Arrays.asList("water_in_pool", "pond_fridge_drink", "pool_wifi_speed"));
        solve(s, al);
    }

    private static ArrayList<Integer> solve(String A, ArrayList<String> B) {
        Set<String> s = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();
        StringTokenizer sr = new StringTokenizer(A, "_");
        while (sr.hasMoreTokens()) {
            s.add(sr.nextToken());
        }
        Collections.sort(B, (x, y) -> {
            StringTokenizer sr1 = new StringTokenizer(x, "_");
            ArrayList<String> a1 = new ArrayList<>();
            while (sr1.hasMoreTokens()) {
                a1.add(sr1.nextToken());
            }
            int count = 0;
            for (String s1 : a1) {
                if (s.contains(s1)) {
                    count++;
                }

            }
            StringTokenizer sr2 = new StringTokenizer(x, "_");
            ArrayList<String> a2 = new ArrayList<>();
            while (sr2.hasMoreTokens()) {
                a2.add(sr2.nextToken());
            }
            int count1 = 0;
            for (String s2 : a2) {
                if (s.contains(s2))
                    count1++;
            }

            if (count > count1)
                return 1;
            else if (count1 > count)
                return -1;
            else
                return 0;
        });
/*        HashMap<String, Integer> h = new HashMap<>();
        for (String str : B) {
            ArrayList<String> a1 = new ArrayList<>();
            StringTokenizer s1 = new StringTokenizer(str, "_");
            while (s1.hasMoreTokens()) {
                a1.add(s1.nextToken());
            }
            int count = 0;
            for (String s2 : a1) {
                if (s.contains(s2))
                    count++;
            }
            h.put(str, count);
        }*/
        return result;
    }
}
