package shasha.company.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class IntegertoRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(48));
    }
    private static String intToRoman(int num){
        TreeMap<Integer,String> h = new TreeMap<>();
        createMap(h);
        StringBuilder sr = new StringBuilder();
        ArrayList<Integer> keys = new ArrayList<Integer>(h.keySet());
        while(num>0){
            for(int i=keys.size()-1; i>=0;i--){
                if(keys.get(i)<=num)
                {
                    num=num-keys.get(i);
                    sr.append(h.get(keys.get(i)));
                }
            }
        }
        return sr.toString();
    }
    private static void createMap(TreeMap<Integer,String> h)
    {
        h.put(1,"I");
        h.put(4,"IV");
        h.put(5,"V");
        h.put(9,"IX");
        h.put(10,"X");
        h.put(40,"XL");
        h.put(50,"L");
        h.put(90,"XC");
        h.put(100,"C");
        h.put(400,"CD");
        h.put(500,"D");
        h.put(900,"CM");
        h.put(1000,"M");
    }
}