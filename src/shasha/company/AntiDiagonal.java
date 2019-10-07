package shasha.company;

import java.util.ArrayList;

public class AntiDiagonal {
    public static void main(String[] args) {
        int a = 1;
        int count = 1;
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            al.add(new ArrayList<>());
            for (int j = 0; j < a; j++) {
                al.get(i).add(count);
                count++;
            }
        }
        diagonal(al);
    }

    private static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        // Upper half of the result
        int row = 0;
        for (int i = 0, j = 0; i < A.size(); i++) {
            j = i;
            int k = 0;
            result.add(new ArrayList<>());
            while (j >= 0) {
                result.get(row).add(A.get(k).get(j));
                j--;
                k++;
            }
            row++;
        }

        //Second half of the result
        for (int i = 1; i < A.size(); i++) {
            result.add(new ArrayList<>());
            int j = A.size() - 1;
            int k = i;
            while (j >= i) {
                result.get(row).add(A.get(k).get(j));
                k++;
                j--;
            }
            row++;
        }

        for (ArrayList<Integer> b : result) {
            for (Integer c : b)
                System.out.print(c + " ");
            System.out.println();
        }
        return result;
    }
}
