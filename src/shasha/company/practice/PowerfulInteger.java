package shasha.company.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PowerfulInteger {
    public static void main(String[] args) {
        System.out.println(powerfulIntegers(2,1,10));
        String s = "dfds";
    }
    public static List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> result = new TreeSet<>();
        int i= 0, j=0;
        if(x==1)
            i=1;
        if(y==1)
            j =1;
        while(x!=1 &&  (int)Math.pow(x,i) <= bound){
            i++;
        }
        while(y !=1 && (int) Math.pow(y,j) <= bound){
            j++;
        }
        if(i==0 || j==0)
            return new ArrayList<>();
        else{
            i--;
            j--;
        }
        for(int k=0;k<=i;k++){
            for(int l =0; l<=j;l++){
                int powSum = (int)(Math.pow(x,k) + Math.pow(y,l));
                if(powSum <= bound)
                    result.add(powSum);
            }
        }
        return new ArrayList<>(result);
    }
}
