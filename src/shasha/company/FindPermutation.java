package shasha.company;

import java.util.ArrayList;
import java.util.Arrays;

public class FindPermutation {

    public static void main(String[] args) {
        ArrayList<Integer> a ;
        String i = "DIDI";
        a=findPerm(i, 5);
        for (Integer c : a)
            System.out.print(c + " ");
        System.out.println();
    }
    private static ArrayList<Integer> findPerm(final String A, int B) {
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0;i<B;i++)
            al.add(0);
        int count=1;
        for(int i=0;i<A.length();i++)
        {
            if(A.charAt(i)=='I'){
                al.set(i,count);
                count++;
            }
        }
        al.set(B-1,count);
        count++;
        for(int i= al.size()-2;i>=0;i--)
        {
            if(al.get(i)==0)
            {
                al.set(i,count);
                count++;
            }
        }
        return al;
    }
}
