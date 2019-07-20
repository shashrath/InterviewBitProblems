package shasha.company.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimizeAbsoluteDifference {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 4, 5, 8, 10));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(6, 9, 15));
        ArrayList<Integer> C = new ArrayList<>(Arrays.asList(2, 3, 6, 6));
        System.out.println(solve(A,B,C));
    }
    private static int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int i, j, k;

        // assigning the length -1 value
        // to each of three variables
        i = A.size() - 1;
        j = B.size() - 1;
        k = C.size() - 1;

        int min_diff, current_diff, max_term;

        // calculating min difference
        // from last index of lists
        min_diff = Math.abs(Math.max(A.get(i), Math.max(B.get(j), C.get(k)))
                - Math.min(A.get(i), Math.min(B.get(j), C.get(k))));

        while (i != -1 && j != -1 && k != -1)
        {
            current_diff = Math.abs(Math.max(A.get(i), Math.max(B.get(j), C.get(k)))
                    - Math.min(A.get(i), Math.min(B.get(j), C.get(k))));

            // checking condition
            if (current_diff < min_diff)
                min_diff = current_diff;

            // calculating max term from list
            max_term = Math.max(A.get(i), Math.max(B.get(j), C.get(k)));

            // Moving to smaller value in the
            // array with maximum out of three.
            if (A.get(i) == max_term)
                i -= 1;
            else if (B.get(j) == max_term)
                j -= 1;
            else
                k -= 1;
        }
        return min_diff;
    }
}
