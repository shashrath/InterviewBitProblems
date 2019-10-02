package shasha.company.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetSum {
    public static void main(String[] args) {
        SubsetSum subsetSum = new SubsetSum();
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(15, 22, 14, 26, 32, 9, 16, 8));
        int num = 53;
        subsetSum.subsetSumSolution(al,num);
    }

    private void subsetSumSolution(ArrayList<Integer> al, int num) {
        ArrayList<Integer> result = new ArrayList<>();
        if(subsetUtility(al, num, result, 0,0))
            printSolution(result);
        else
            System.out.println("No Solution found");
    }
    private void  printSolution(ArrayList<Integer> al){
        for(int i: al)
            System.out.print(i + " ");
        System.out.println();
    }

    private boolean subsetUtility(ArrayList<Integer> al, int num, ArrayList<Integer> result, int pos,int sum) {
            if(sum==num)
                return true;
            if(sum>num)
                return false;
            for(int i=pos;i<al.size();i++){
                result.add(al.get(i));
                sum=sum+al.get(i);
                if(subsetUtility(al,num,result,pos+1,sum))
                    return true;
                else{
                    result.remove(al.get(i));
                    sum=sum-al.get(i);
                }
            }
            return false;
    }
}
