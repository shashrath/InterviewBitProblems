package shasha.company.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxContinousSeriesof1 {
    public static void main(String[] args) {
        ArrayList<Integer> a1 = new ArrayList<>(Arrays.asList(1,0,0,1,1,0,1,0,1,1,1,1));
        ArrayList<Integer> a2 = new ArrayList<>();
        a2= maxone(a1,2);
        for(Integer a: a2)
            System.out.print(a+" ");
        System.out.println();
    }
    private static  ArrayList<Integer> maxone(ArrayList<Integer> A, int m) {
        Integer wL=0,wR=0,zC=0,mL=0,si=-1,ei=-1;
        for(wR=0;wR<A.size();wR++)
        {
            if(A.get(wR)==0){
                zC++;
                if(zC>m)
                {
                    while(wL<wR && A.get(wL)!=0) // Silly Mistake in this Line
                    {
                        wL++;
                    }
                    wL++;
                    zC--;
                }
            }
            if(mL<(wR-wL)+1)
            {
                mL=wR-wL+1;
                si=wL;
                ei=wR;
                //System.out.println(wL);
                //System.out.println(wR);
                //System.out.println("***********************");
            }
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i=si;i<=ei;i++)
        {
            result.add(i);
        }
        return result;
    }
}
