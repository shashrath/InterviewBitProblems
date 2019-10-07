package shasha.company.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicatesArray {
    public static void main(String[] args) {
        ArrayList<Integer> a1 = new ArrayList<>(Arrays.asList(0, 0, 1, 1, 2, 3, 3));
        System.out.println(removeDuplicates(a1));
    }

    private static int removeDuplicates(ArrayList<Integer> a) {
        int i = 1, j = 0, count = 1;
        while (i < a.size()) {
            while (i < a.size() && a.get(i).equals(a.get(j))) {
                i++;
            }
            if (i < a.size()) {
                if (i - j > 1) {
                    j++;
                    a.set(j, a.get(i));
                    j++;
                    a.set(j, a.get(i));

                } else {
                    j++;
                    a.set(j, a.get(i));
                }
            }
        }
        return j + 1;
    }
}
