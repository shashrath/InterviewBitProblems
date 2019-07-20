package shasha.company.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicates2 {
    public static void main(String[] args) {
        ArrayList<Integer> a1 = new ArrayList<>(Arrays.asList(1,1));
        System.out.println(removeDuplicates(a1));
    }
    private static int removeDuplicates(ArrayList<Integer> a) {
        int i=0,j=0,k=0;
        while(i<a.size()){
            k=i+1;
            while(k<a.size() && a.get(i).equals(a.get(k))){
                k++;
            }
            if(k<a.size()){
                if(k-i>1){
                    a.set(j+1,a.get(j));
                    j=j+2;
                    a.set(j,a.get(k));
                }
                else{
                    j++;
                    a.set(j,a.get(k));
                }
            }
            if(k==a.size())
            {
                if(k-i>1){
                    a.set(j+1,a.get(j));
                    j++;
                }
            }
            i=k;

        }
        return j+1;
    }
}
