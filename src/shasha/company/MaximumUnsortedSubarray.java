package shasha.company;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumUnsortedSubarray {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(3, 8, 2, 5, 6, 7, 1));
        subUnsort(a);

    }

    private static ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        int s = -1, e = -1;
        ArrayList<Integer> result = new ArrayList<>();

        //Scan for first unsorted element from left
        for (int i = 0; i < A.size() - 1; i++) {
            if (A.get(i) > A.get(i + 1)) {
                s = i;
                break;
            }

        }

        if (s == -1) {
            result.add(-1);
            return result;
        }

        // Scan for first unsorted element from right
        for (int i = A.size() - 1; i >= 1; i--) {
            if (A.get(i) < A.get(i - 1)) {
                e = i;
                break;
            }

        }
        int max, min;
        max = findMax(A, s, e);
        min = findMin(A, s, e);

        int j = s;
        while (j >= 0 && A.get(j) > min) {
            s = j;
            j--;
        }

        j = e;
        while (j < A.size() && A.get(j) < max) {
            e = j;
            j++;
        }
        result.add(s);
        result.add(e);
        for (Integer i : result) {
            System.out.print(i + " ");
        }
        return result;
    }

    private static int findMax(ArrayList<Integer> A, int s, int e) {
        int max = A.get(s);
        for (int i = s; i <= e; i++) {
            if (A.get(i) > max)
                max = A.get(i);
        }
        return max;
    }

    private static int findMin(ArrayList<Integer> A, int s, int e) {
        int min = A.get(s);
        for (int i = s; i <= e; i++) {
            if (A.get(i) < min)
                min = A.get(i);
        }
        return min;
    }
}
