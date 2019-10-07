package shasha.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatMoreThan3 {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(3, 2, 1, 2, 3, 7));
        System.out.println(repeatedNumber(al));
    }

    private static int repeatedNumber(final List<Integer> a) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        int count1 = 0, count2 = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) == first)
                count1++;
            else if (a.get(i) == second)
                count2++;
            else if (count1 == 0) {
                first = a.get(i);
                count1 = 1;
            } else if (count2 == 0) {
                second = a.get(i);
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) == first)
                count1++;
            else if (a.get(i) == second)
                count2++;
        }
        if (count1 > a.size() / 3)
            return first;
        else if (count2 > a.size() / 3)
            return second;
        else
            return -1;
    }
}
