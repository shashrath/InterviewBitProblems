package shasha.company.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        ArrayList<ArrayList<Integer>> result = combinations.combine(4, 4);
        for(List<Integer> list : result){
            for(Integer i: list){
                System.out.print(i);
            }
            System.out.println();
        }
    }

    private ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        findSolutionUtil(result, new ArrayList<>(), n, k, 1);
        return result;
    }

    private void findSolutionUtil(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, int n, int k, int start) {
        if (k == 0) {
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = start; i <= n; i++) {
            temp.add(i);
            findSolutionUtil(result, temp, n, k - 1, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
