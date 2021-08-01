package shasha.company.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WordFilter {
    public static void main(String[] args) {
        String [] words = {"cabaabaaaa","ccbcababac","bacaabccba","bcbbcbacaa","abcaccbcaa","accabaccaa","cabcbbbcca","ababccabcb","caccbbcbab","bccbacbcba"};
        WordFilter wordFilter = new WordFilter(words);
        int result = wordFilter.f("ab","abcaccbcaa");
        System.out.println(result);
    }

    private Map<String,Integer> dict = new HashMap<>();

    public WordFilter(String[] words) {
        ArrayList<String> prefixList = new ArrayList<>();
        ArrayList<String> suffixList = new ArrayList<>();
        for(int k =0;k<words.length;k++){
            populatePrefixList(words[k],prefixList);
            populuateSuffixList(words[k],suffixList);
            for(int i=0;i<prefixList.size();i++){
                for(int j=0;j<suffixList.size();j++){
                    String sum = prefixList.get(i) + '#' + suffixList.get(j);
                    dict.put(sum,k);
                }
            }
            prefixList.clear();
            suffixList.clear();
        }
    }

    public void populatePrefixList(String s, List<String> prefixList){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            prefixList.add(sb.toString());
        }
    }

    public void populuateSuffixList(String s, List<String> suffixList){
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for(int i =0 ;i< len;i++){
            suffixList.add(s.substring(len-1-i,len));
        }
    }

    public int f(String prefix, String suffix) {
        String sum = prefix + '#' + suffix;
        return dict.getOrDefault(sum, -1);

    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
