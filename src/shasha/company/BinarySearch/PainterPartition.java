package shasha.company.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class PainterPartition {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(1000000,1000000  ));
        System.out.println(paint(1,1000000,al));
    }
    private static int paint(int A, int B, ArrayList<Integer> C) {
        long high = findSum(C);
        long lo = findMax(C);
        if(A>C.size())
            return (int)((lo*B)%10000003);
        if(A==1)
            return (int)((high*B)%10000003);
        while(lo<=high){

            long mid=lo+(high-lo)/2;
            int painters=partition(mid,C);
            if(painters<=A)
                high=mid-1;
            else if(painters>A)
            {
                lo=mid+1;
            }
        }
        return (int)((lo*B)%10000003);
    }
    private static int partition(long val, ArrayList<Integer> C)
    {
        int painters=1;
        long total=0;
        for(int i=0;i<C.size();i++)
        {
            total=total+C.get(i);
            if(total>val){
                total=C.get(i);
                painters++;
            }
        }
        return painters;
    }

    private static int findSum(ArrayList<Integer> C)
    {
        return C.stream().mapToInt(value -> value).sum();
    }

    private static  Integer findMax(ArrayList<Integer> C){
        try{
            return C.stream().mapToInt(v ->v).max().orElseThrow(NoSuchElementException::new);
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        return -1;
    }


}
