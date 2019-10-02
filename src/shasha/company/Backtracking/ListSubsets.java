package shasha.company.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ListSubsets {
    public static void main(String[] args) {
        ListSubsets listSubsets = new ListSubsets();
        ArrayList<Integer> some = new ArrayList<>(Arrays.asList(1,2,3));
        listSubsets.subsets(some);
    }
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Collections.sort(A);
        result.add(new ArrayList<Integer>());
        subsetUtil(result,A,result.get(0),0);
        return result;
    }
    private void subsetUtil(ArrayList<ArrayList<Integer>> result,ArrayList<Integer> A,ArrayList<Integer> prev, int pos){
        for(int i=pos;i<A.size();i++)
        {
            System.out.println("Value of Pos: "+ pos + " and i: "+ i);
            result.add(new ArrayList<Integer>());
            ArrayList<Integer> curr = result.get(result.size()-1);
            for(Integer p: prev)
                curr.add(p);
            curr.add(A.get(i));
            subsetUtil(result,A,curr,i+1);
        }
    }
}
