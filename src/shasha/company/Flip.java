package shasha.company;

import java.util.ArrayList;

public class Flip {
    public static void main(String[] args) {
        String s = "000100";
        flip(s);
    }
    private static ArrayList<Integer> flip(String A) {
        ArrayList<Integer> result = new ArrayList<>();
        int count1=0;
        int count0=0;
        int max=0;
        int minl=-1,minr=-1;
        int l=0,r=0;
        for(int i=0;i<A.length();i++)
        {
            if(A.charAt(i)=='0'){
                count0++;
                if(count0>max){
                    max=count0;
                    r=i;
                    minl=l;
                    minr=r;
                }

            }
            else{
                count0--;
                if(count0<0)
                {
                    count0=0;
                    l=i+1;
                    r=i+1;
                }
            }

        }
        if(minl==-1)
            return result;
        else{
            result.add(minl+1);
            result.add(minr+1);
            System.out.println(result.get(0) +" "+ result.get(1));
        }

        return result;
    }
}
