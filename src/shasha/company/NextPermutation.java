package shasha.company;

import java.util.ArrayList;
import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(2, 4, 3, 2, 1));
        nextPermutation(a);
        for (Integer c : a)
            System.out.print(c + " ");
        System.out.println();
    }

    private static void nextPermutation(ArrayList<Integer> a) {
        boolean flag = false;
        for (int i = a.size() - 1; i > 0; i--) {
            if (a.get(i) > a.get(i - 1)) {
                int j = i;
                while (j < a.size() && a.get(j) > a.get(i - 1)) {
                    j++;
                }
                swap(a, i - 1, j - 1);
                reverse(i, a.size() - 1, a);
                return;
            }
        }
        int l = 0, r = a.size() - 1;
        reverse(l, r, a);
    }

    private static void reverse(int l, int r, ArrayList<Integer> a) {
        while (l < r) {
            swap(a, l, r);
            l++;
            r--;
        }
    }

    private static void swap(ArrayList<Integer> a, int i, int j) {
        int temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
    }
}
