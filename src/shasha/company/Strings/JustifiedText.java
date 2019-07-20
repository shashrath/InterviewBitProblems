package shasha.company.Strings;

import java.util.ArrayList;
import java.util.Arrays;

public class JustifiedText {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>(Arrays.asList("lkgyyrqh", "qrdqusnh", "zyu", "w", "ukzxyykeh", "zmfqafqle", "e", "ajq", "kagjss", "mihiqla", "qekf", "ipxbpz", "opsndtyu", "x", "ec", "cbd", "zz", "yzgx", "qbzaffgf", "i", "atstkrdph", "jgx", "qiy", "jeythmm", "qgqvyz", "dfagnfpwat", "sigxajhjt", "zx", "hwmcgss"));
        ArrayList<String> result;
        result =fullJustify(al,178);
        for(String sr: result)
        {
            System.out.println(sr);
        }
    }
    private static ArrayList<String> fullJustify(ArrayList<String> A, int B) {
        int count=0,start=0,end=0,space=0;
        boolean uneven =false;
        int unevenGap =0;
        ArrayList<String> result = new ArrayList<>();
        for(int i=0;i<A.size();i++)
        {
            if(A.get(i).trim().isEmpty())
                continue;
            if(count+A.get(i).length() <= B)
            {
                end++;
                space++;
                count=count+A.get(i).length()+1;
            }
            else{

                count--;
                space--;
                int gap=0;
                if(space>0){
                    gap=1;
                    int diff=B-count;
                    if(diff%space==0){
                        gap=gap+diff/space;
                    }
                    else{
                        gap=gap+diff/space;
                        uneven=true;
                        unevenGap=diff%space;
                    }
                }
                StringBuilder sr = new StringBuilder();
                while(start<end){
                    sr.append(A.get(start));
                    if(space>0){
                        for(int k=0;k<gap;k++)
                            sr.append(" ");
                        if(uneven && unevenGap>0)
                        {
                            sr.append(" ");
                            unevenGap--;
                        }
                        space--;
                    }
                    start++;
                }
                while(sr.toString().length()<B)
                {
                    sr.append(" ");
                }
                result.add(sr.toString());
                count=A.get(i).length()+1;
                space++;
                end++;
            }
        }
        space--;
        StringBuilder sr = new StringBuilder();
        while(start<end){
            sr.append(A.get(start));
            sr.append(" ");
            start++;
            }
        if(sr.toString().isEmpty());
        else
        {
            sr.deleteCharAt(sr.toString().length()-1);
            count = sr.toString().length();
            if(!result.isEmpty())
            {
                while(count<result.get(0).length()){
                    sr.append(" ");
                    count++;
                }
            }
            else{
                while(count<B){
                    sr.append(" ");
                    count++;
                }
            }
            result.add(sr.toString());
        }

        return result;
    }
}
