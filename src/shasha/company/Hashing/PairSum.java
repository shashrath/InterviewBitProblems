package shasha.company.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class PairSum {
    public static void main(String[] args) {
        PairSum pairSum = new PairSum();
        List<Integer> al = new ArrayList<>(Arrays.asList(2,7,11,5));
        ArrayList<Integer> result = pairSum.twoSum(al,9);
        System.out.println("First Index : "+ result.get(0) + " Second Index : "+ result.get(1));
    }

    private ArrayList<Integer> twoSum(final List<Integer> A, int B) {
        LinkedHashMap<Integer, Integer> h = new LinkedHashMap<>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        int firstValue;
        for (int i = 0; i < A.size(); i++) {
            firstValue = B - A.get(i);
            if (h.containsKey(firstValue)) {
                if (result.isEmpty()) {
                    result.add(h.get(firstValue) + 1);
                    result.add(i + 1);
                    break;
                }
            }
            if (!h.containsKey(A.get(i)))
                h.put(A.get(i), i);
        }
        return result;
    }
}
