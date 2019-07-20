package shasha.company.Strings;

import java.util.ArrayList;
import java.util.Arrays;

public class Stringoholics {
    public static void main(String[] args) {
        ArrayList<String> str = new ArrayList<>(Arrays.asList("babbaabbbaabababbbbbaaabbaabaabbaaabaaaaabbbabababbabbaa", "aabababbbaabaabbbaaaabaaabbbbaababbbaaabaaabababaabaaaaaba", "aaabaaababbbbabaaabaabbbbbbaabaababbaaaab", "baaababaa", "baabbababbabbaaaababbabbaabbaabaabbbbabbbaaaaaaabbbababbbbbbbabbbaabaaabaaaaaaaabbaaba", "abbaabbbaabbabbabbabaabaaaaaaaaabbabaaabaaaabaabbaabbabbaabaaabab", "bababbababbaabbbaababbaaaaabaaaaaaabbaabbaaabbbbba", "abbababaabbabbaaaaaaaaaabbbbabaaaaaaabaaabbbabbbaabaabaaabbaabaabaababaaabababaa", "baaaaaabbabaaaaaababbbaabbbabbaaaa", "aaaababbabbaabbbaabbbaabbbbbbbbabbaabbabbbaba", "abbaaaaaba", "bbbabbaabaaaabba", "aaabbbbbbbbbbbabaaabaaab", "abaabbaaabbbabbaaabbaabaaabbaabbbbbbbbbbbaabbbbabbbbbbaabbbababaaabbbaaabaaaababa", "babbaaababbbbbbbabbababbbbbbabbbbaabbaabbabbb", "aabbabababababbaaaababbabbaaa", "aaaababbabaabbbabaabbabababbabbabbababaabba", "aaabaaabbbbabbbbaba", "aabaabababbabbbbbaaabbabaaabbabbbaabbaaabbaaaabbababbaabababbbbabbbbbbbbabbabbabaabbabbbaba", "bbaaaabababaaaabbabaaabbbaaaaaabaabaabaabbabaabbbabbababbabbbbabaababaaabaabbbbababbbaabaaabbbabbaa", "aaabbababaaaabbababaabbbaab", "abbababaaaaaaaabaabbaababbbababbbbbbbabbbabbaa", "aabaabbababbbaaabbbaaaaababaabbbbabbaabbbbaababaaabaababbaabbbabbbabaaabbababaabbbbbaabbabbbaba", "bbbbbbaaababaaababaabbababbaababababaabaabbaabbabbaabaabbbaaaabbbaabaaaabbab", "bbabaaaaababbaabbbabbaabaabb", "aaaaababbabbabaabaaaabbabbaaaabaababbaaabbbbaa", "baababb", "babbabaa", "bbbabbbaaaabaaaaaabbbaabbbbbbbbbaababaabbaababaabbaababaaabbbaaaaaaba", "bbbbbbababaabbaabaabaabaaaaabbaaababbaabaab", "bbabaaaaabaabbababbaababaaaabbbabbbb", "bbabbbaabbaabbbabaabbaaaabbbaabababbbbbabababaaaabbbbaabbbbba", "bbaaabaaababbbbbbbaabaabb", "aababaabbabbabaaabbbaaabbbbbaabbbabaabbbaaaababbbaaabbbaaabbaaababbbbbabbbbbbaabbbbaaaaaab", "aabaabbbaaababababbbaaaaaaabababbabababbbbabaaabbbababbabbbababaaaabaaabbaaaaabaabbaabaaaaabab", "ababbabbabbababbaababaabaabaaaaababababbbbbbbaababbbbbaaabaabab", "aabbbaaabbbababababbaababbabbbbbaabbbbbabbbabaaababba", "bbbbaabaabababababababbaaaabbaaaabaaabaaabbaabbababbbbbbbabbabbaabbaabaaa", "abbabaabbbaabbaaabbabbbaaaaaaaabbbbbbbaaaaabbbbaaaababaabaaaaababa", "abbabbbbaaaaababbabbbbbbaaaabababaabbbabbaabbaba", "abaabbabaaaabaabbbaabbabbbbaababbabaabbabbaaaabbbbbaabaabbabaaabbbbbaabbabbaaab", "baaaaaabbaababbbaaabbbabbabbaaaaaaaa", "abbaababaabaaabababbbabbababbabbabbaaabaaaaabaaaabb", "babaabbbaababaababbababaabaabbaaaaaabbbbaabbbbbbaaaaabaaabbbabaabaaba", "aaaabbbababbabaaaabbaaaaaaabbabbabbabbaabbbbbbb"));
        System.out.println(solve(str));
    }
    private static int solve(ArrayList<String> A) {
        ArrayList<Long> al = new ArrayList<>();
        for(String sr: A)
        {
            al.add(rotateMatch(sr));
        }
        return (int)(lcm_of_array_elements(al)%1000000007);
    }
    public static long lcm_of_array_elements(ArrayList<Long> a)
    {
        long lcm = 1;
        int divisor = 2;

        while (true) {
            int counter = 0;
            boolean divisible = false;

            for (int i = 0; i < a.size(); i++) {

                // lcm_of_array_elements (n1, n2, ... 0) = 0.
                // For negative number we convert into
                // positive and calculate lcm_of_array_elements.

                if (a.get(i) == 0) {
                    return 0;
                }
                else if (a.get(i) < 0) {
                   a.set(i,a.get(i)*-1);
                }
                if (a.get(i) == 1) {
                    counter++;
                }

                // Divide element_array by devisor if complete
                // division i.e. without remainder then replace
                // number with quotient; used for find next factor
                if (a.get(i)% divisor == 0) {
                    divisible = true;
                    a.set(i,a.get(i)/divisor);
                }
            }

            // If divisor able to completely divide any number
            // from array multiply with lcm_of_array_elements
            // and store into lcm_of_array_elements and continue
            // to same divisor for next factor finding.
            // else increment divisor
                if (divisible) {
                lcm = lcm * divisor;
            }
            else {
                divisor++;
            }

            // Check if all element_array is 1 indicate
            // we found all factors and terminate while loop.
            if (counter == a.size()) {
                return lcm;
            }
        }
    }
    private static long rotateMatch(String str){
        if(str.isEmpty() || str.length()==1)
            return str.length();
        StringBuilder sr = new StringBuilder();
        boolean flag=true;
        int i=0,n=str.length();
        while(!str.contentEquals(sr)){
            if(flag){
                sr.append(str);
                flag=false;
            }
            i++;
            i = i%n;

            reverse(sr,0,i-1);
            reverse(sr,i,n-1);
            reverse(sr,0,n-1);
        }
        return i;
    }
    private static void reverse(StringBuilder sr,int start, int last){
        while(start<=last){
            char temp = sr.charAt(start);
            sr.setCharAt(start,sr.charAt(last));
            sr.setCharAt(last,temp);
            start++;
            last--;
        }
    }
}
