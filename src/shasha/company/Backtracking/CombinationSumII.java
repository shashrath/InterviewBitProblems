package shasha.company.Backtracking;

import java.util.*;

public class CombinationSumII {
    private ArrayList<ArrayList<Integer>> result;

    public static void main(String[] args) {
        CombinationSumII combinationSumII = new CombinationSumII();
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(10,1,2,7,6,1,5));
        combinationSumII.combinationSum(al, 8);
        combinationSumII.printSolution2D();
    }

    private void printSolution2D() {
        for (ArrayList<Integer> al : result) {
            for (Integer a : al)
                System.out.print(a + " ");
            System.out.println();
        }

    }

    private void combinationSum(ArrayList<Integer> a, int b) {
        Collections.sort(a);
        result = new ArrayList<>();
        sumUtilFunc(result, a, b, new ArrayList<Integer>(), 0, 0);
        Set<ArrayList<Integer>> s = new LinkedHashSet<>(result);
        result.clear();
        result.addAll(s);
    }

    private void sumUtilFunc(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> a, int b, ArrayList<Integer> temp, int sum, int pos) {
        if (sum > b) ;
        else if (sum == b) {
            result.add(new ArrayList<Integer>(temp));
        } else {
            for (int i = pos; i < a.size(); i++) {
                temp.add(a.get(i));
                sumUtilFunc(result, a, b, temp, sum + a.get(i), i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
