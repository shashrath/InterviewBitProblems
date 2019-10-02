package shasha.company.Backtracking;

import java.util.*;

public class CombinationSum {
    private ArrayList<ArrayList<Integer>> result;

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(2, 3, 6, 7));
        combinationSum.combinationSum(al, 7);
        combinationSum.printSolution2D();
    }

    private void printSolution2D() {
        for (ArrayList<Integer> al : result) {
            for (Integer a : al)
                System.out.print(a + " ");
            System.out.println();
        }

    }

    private void combinationSum(ArrayList<Integer> A, int B) {
        result = new ArrayList<>();
        Collections.sort(A);
        sumUtil(result, A, new ArrayList<Integer>(), B, 0, 0);
        Set<ArrayList<Integer>> set = new LinkedHashSet<>(result);
        result.clear();
        result.addAll(set);
        //printSolution2D();
    }

    private void sumUtil(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> A, ArrayList<Integer> temp, int B, int sum, int pos) {
        if (sum == B)
            result.add(new ArrayList<Integer>(temp));
        else if (sum > B)
            return ;
        else {
            for (int i = pos; i < A.size(); i++) {
                temp.add(A.get(i));
                sumUtil(result, A, temp, B, sum + A.get(i), i);
                temp.remove(temp.size()-1);
            }
        }

    }
}
