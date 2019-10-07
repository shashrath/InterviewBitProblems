package shasha.company.Backtracking;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MColoringProblem {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        al.add(new ArrayList<>(Arrays.asList(0, 1, 1, 1)));
        al.add(new ArrayList<>(Arrays.asList(1, 0, 1, 0)));
        al.add(new ArrayList<>(Arrays.asList(1, 1, 0, 1)));
        al.add(new ArrayList<>(Arrays.asList(1, 0, 1, 0)));
        MColoringProblem mColoringProblem = new MColoringProblem();
        System.out.println(mColoringProblem.mColor(al,3));
    }
    private boolean mColor(ArrayList<ArrayList<Integer>> graph,int n){
        ArrayList<Integer> color = new ArrayList<>(Collections.nCopies(4,1));
        boolean flag;
        int c =1;
        for(int i=0;i<graph.size();i++){
            flag = false;
            for(int j=0;j<graph.get(i).size();j++)
            {
                if(graph.get(i).get(j)==1 && color.get(i).equals(color.get(j)))
                {
                    if(!flag){
                        c++;
                        flag=true;
                    }
                    color.set(j,c);
                }
            }
        }
        System.out.println("Printing Color Array");
        for(Integer i: color)
        {
            System.out.print(i + " ");
        }
        System.out.println();
        for(Integer i: color)
        {
            if(i> n)
                return false;
        }
        return true;
    }
}
