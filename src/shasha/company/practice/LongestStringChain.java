package shasha.company.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {
    public static void main(String[] args) {
        String words[] = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        longestStrChain(words);
    }
    public static int longestStrChain(String[] words) {
        Arrays.sort(words, (x, y)-> Integer.compare(x.length(),y.length()));
        HashMap<String,Integer> hash = new HashMap<>();
        int max = 0;
        for(String word: words){
            StringBuilder sb = new StringBuilder(word);
            hash.put(word,1);
            max =1;
            for(int i=0;i<word.length();i++){
                char c = word.charAt(i);
                sb.deleteCharAt(i);
                if(hash.containsKey(sb.toString())){
                    max = Math.max(hash.get(sb.toString())+1,hash.get(word));
                    hash.put(word,max);
                }
                sb.insert(i, c);
            }
        }
        max = 1;
        for(Map.Entry<String,Integer> entry : hash.entrySet()){
            max = Math.max(entry.getValue(),max);
        }
        return max;
    }
}
