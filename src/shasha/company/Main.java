package shasha.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        ArrayList<Integer> a1 = new ArrayList<>(Arrays.asList(1, 1));
        ArrayList<Integer> a2 = new ArrayList<>(Arrays.asList(0, 1));
        ArrayList<Integer> a3 = new ArrayList<>(Arrays.asList(1, 1, 0, 1));
        ArrayList<Integer> a4 = new ArrayList<>(Arrays.asList(1, 1, 1, 1));
        a.add(a1);
        a.add(a2);
        //      a.add(a3);
        //    a.add(a4);
        setZeroes(a);
        for (ArrayList<Integer> i : a) {
            for (Integer j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    private static void setZeroes(ArrayList<ArrayList<Integer>> a) {
        boolean rowZero = false, columnZero = false;

        // checking row is zero
        for (int i = 0; i < a.get(0).size(); i++) {
            if (a.get(0).get(i) == 0)
                columnZero = true;
        }

        // Checking column is zero
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).get(0) == 0)
                rowZero = true;
        }

        // Filling first row and column with zero
        for (int i = 1; i < a.size(); i++) {
            for (int j = 1; j < a.get(0).size(); j++) {
                if (a.get(i).get(j) == 0) {
                    a.get(i).set(0, 0);
                    a.get(0).set(j, 0);
                }
            }
        }

        // Using the values from first column
        for (int i = 1; i < a.get(0).size(); i++) {
            if (a.get(0).get(i) == 0) {
                for (int j = 1; j < a.size(); j++) {
                    a.get(j).set(i, 0);
                }
            }
        }

        //Using the values from first row
        for (int i = 1; i < a.size(); i++) {
            if (a.get(i).get(0) == 0) {
                for (int j = 1; j < a.get(0).size(); j++) {
                    a.get(i).set(j, 0);
                }
            }
        }

        // If column had zero set the entire first column to zero
        if (columnZero) {
            for (int i = 0; i < a.get(0).size(); i++) {
                a.get(0).set(i, 0);
            }
        }

        // If row had zero set the entire first row as zero
        if (rowZero) {
            for (int i = 0; i < a.size(); i++) {
                a.get(i).set(0, 0);
            }
        }
    }

}


