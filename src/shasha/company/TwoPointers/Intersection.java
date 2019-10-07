package shasha.company.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersection {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1000));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(1000));
        intersect(a, b);
    }

    private static ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = A.size(), m = B.size(), i = 0, j = 0;
        while (i < n && j < m) {
            if (A.get(i).equals(B.get(i))) {
                result.add(A.get(i));
                i++;
                j++;
            } else if (A.get(i) > B.get(j))
                j++;
            else
                i++;
        }
        return result;
    }
}
