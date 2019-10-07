package shasha.company.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(2, 1, 0));
        sortColors(al);
    }

    private static void sortColors(ArrayList<Integer> a) {
        int c1 = -1, c2 = 0, c3 = a.size() - 1;
        while (c2 < c3) {
            if (a.get(c3) == 2) {
                c3--;
            }
            if (a.get(c2) == 0) {
                a.set(c2, 1);
                a.set(c1 + 1, 0);
                c1++;
                c2++;
            } else if (a.get(c2) == 1) {
                c2++;
            } else if (a.get(c2) == 2) {
                a.set(c2, a.get(c3));
                a.set(c3, 2);
                c3--;
            }
        }
    }
}
