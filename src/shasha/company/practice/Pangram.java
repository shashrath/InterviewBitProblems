package shasha.company.practice;

import java.util.HashMap;
import java.util.Map;

public class Pangram {
    public static void main(String[] args) {
        System.out.println(checkIfPangram("onrcsnlxckptsxffbyswujpamfltvmdoxovggepknmtacrjkkorjgvgtgaiaudspnpxkwikevmjeephhiyvnoymjwjfopovscbefecnoytjxfwasabwohqujwowmakpyuuqvgfab"));
    }

    public static boolean checkIfPangram(String sentence) {
        char ch = 97;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<=25;i++){
            map.put(ch,0);
            ch +=1;
        }
        char[] sArray = sentence.toCharArray();
        for(char c : sArray){
            map.put(c,1);
        }
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue() == 0)
                return false;
        }
        return true;
    }
}
