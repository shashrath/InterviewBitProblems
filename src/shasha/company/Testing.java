package shasha.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Testing {

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(4, 5, 9, 10, 1, 2));
        System.out.println(firstMissingPositive(al));
    }

    private static int firstMissingPositive(ArrayList<Integer> A) {
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) < 1) {
                A.set(i, A.size() + 5);
            }
        }
        for (int i = 0; i < A.size(); i++) {
            if (Math.abs(A.get(i)) <= A.size()) {
                if (A.get(Math.abs(A.get(i) - 1)) > 0) {
                    A.set(Math.abs(A.get(i)) - 1, -A.get(Math.abs(A.get(i) - 1)));
                }
            }
        }
        int i = 0;
        while (i < A.size() && A.get(i) < 0) {
            i++;
        }
        return i + 1;
    }
}
