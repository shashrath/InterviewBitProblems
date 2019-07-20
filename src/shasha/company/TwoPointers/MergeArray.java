package shasha.company.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeArray {
    public static void main(String[] args) {
        ArrayList<Integer> a1 = new ArrayList<>(Arrays.asList(1,5,8));
        ArrayList<Integer> a2 = new ArrayList<>(Arrays.asList(6,9));
        merge(a1,a2);
        for(Integer a: a1)
            System.out.print(a+" ");
        System.out.println();
    }
    private static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        int j=0;
        int i=0;
        while (i<a.size() && j<b.size()){
          if(a.get(i)>b.get(j)){
              a.add(i,b.get(j));
              j++;
          }
          else
              i++;
        }
        while(j<b.size()){
            a.add(b.get(j));
            j++;
        }

    }
}
