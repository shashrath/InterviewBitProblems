package shasha.company;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumAbsoluteDifference {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(1,3,-1,4,5,6,7,8));
        System.out.println(maxArr(al));
    }
    private static int maxArr(ArrayList<Integer> a) {
        int max1 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE, min2 = Integer.MAX_VALUE;

        for (int i = 0; i < a.size(); i++) {

            // Updating max and min variables
            // as described in algorithm.
            max1 = Math.max(max1, a.get(i) + i);
            min1 = Math.min(min1, a.get(i) + i);
            max2 = Math.max(max2, a.get(i) - i);
            min2 = Math.min(min2, a.get(i) - i);
        }
        return Math.max(max1-min1,max2-min2);
    }
}
