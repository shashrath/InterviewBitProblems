package shasha.company.practice;

import java.util.ArrayList;
import java.util.List;

public class PasacalsTriangle {
    public static void main(String[] args) {
        List<List<Integer>> result = generate(5);
        for(List<Integer> row: result){
            for(Integer i: row){
                System.out.print(i+ " ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> prev;
        List<Integer> curr = new ArrayList<>();
        curr.add(1);
        result.add(new ArrayList<>(curr));
        prev = new ArrayList<>(curr);
        for(int i=2;i<=numRows;i++)
        {
            curr = new ArrayList<>(prev);
            for(int j=1;j<prev.size();j++)
            {
                curr.set(j,prev.get(j-1)+prev.get(j));
            }
            curr.add(1);
            result.add(new ArrayList<>(curr));
            prev = curr;
        }
        return result;
    }
}
