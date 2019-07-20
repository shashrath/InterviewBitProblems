package shasha.company.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveElementFromArray {
    public static void main(String[] args) {
        ArrayList<Integer> a1 = new ArrayList<>(Arrays.asList(4,1,1,5,1,2,8,1));
        System.out.println(removeElement(a1,1));
        for(Integer a: a1)
            System.out.print(a+" ");
        System.out.println();
    }
    private static int removeElement(ArrayList<Integer> a, int b) {
        int i=0,j=0,n=a.size(),count=0;
        while(i<a.size()){
            if (a.get(i) != b){
                a.set(j,a.get(i));
                j++;
                count++;
            }
                i++;
            }
        return count;
    }
}
