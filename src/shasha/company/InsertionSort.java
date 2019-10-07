package shasha.company;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(5, 7, 8, 1, 4, 6, 3, 2));
        sort(al);
        for (Integer c : al) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    private static void sort(ArrayList<Integer> a) {
        for (int j = 1; j < a.size(); j++) {
            int key = a.get(j);
            int i = j - 1;
            while (i >= 0 && key < a.get(i)) {
                a.set(i + 1, a.get(i));
                i--;
            }
            a.set(i + 1, key);
        }
    }
}
