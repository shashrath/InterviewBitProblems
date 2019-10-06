package shasha.company.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LargestContigousZeroSum {
    public static void main(String[] args) {
        LargestContigousZeroSum largestContigousZeroSum = new LargestContigousZeroSum();
        largestContigousZeroSum.lszero(new ArrayList<>(Arrays.asList(-2, 3, 5, 0)));
    }

    private ArrayList<Integer> lszero(ArrayList<Integer> A) {

        int N = A.size();

        HashMap<Long, Integer> hm = new HashMap<Long, Integer>();

        Long sum = 0L;

        hm.put(0L, -1);

        int sKey = -1;
        int len = 0;

        for (int i = 0; i < N; i++) {

            sum += A.get(i);

            if (hm.containsKey(sum)) {
                if (i - hm.get(sum) > len) {
                    sKey = hm.get(sum);
                    len = i - hm.get(sum);
                }
            } else {
                hm.put(sum, i);
            }

        }

        // System.out.print(hm);


        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = sKey + 1; i <= sKey + len; i++) {
            arr.add(A.get(i));
        }

        return arr;
    }
}
