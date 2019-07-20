package shasha.company;

import java.util.ArrayList;

public class PascalTriangle {
    public static void main(String[] args) {
        System.out.println(solve(2));
    }
    private static int solve(int a) {
        ArrayList<Integer> pre = new ArrayList<>();
        pre.add(1);
        for(int i=1 ;i<a;i++){
            ArrayList<Integer> curr= new ArrayList<>();
            curr.add(1);  //First
            for(int j=1; j<pre.size(); j++)
            {
                curr.add(pre.get(j)+pre.get(j-1));
            }
            curr.add(1); // Last
            pre=curr;
        }
        for(Integer i: pre)
        {
            System.out.print(i);
        }
        System.out.println();
        return 0;
    }
}
