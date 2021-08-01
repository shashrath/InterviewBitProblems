package shasha.company.dynamicprogramming;

import java.util.Arrays;

public class DecodeWays {
    public static void main(String[] args) {
        System.out.println(numDecodings("12"));
    }

    public static int numDecodings(String s) {
        int n = s.length();
        int dp[] = new int[n+1];
        Arrays.fill(dp,0);
        dp[0] =1;
        dp[1] =1;
        for(int i=2;i<=n;i++){
            if(Integer.parseInt(s.substring(i-1,i)) > 0 && Integer.parseInt(s.substring(i-1,i)) <= 9)
                dp[i] = dp[i-1];
            if(Integer.parseInt(s.substring(i-2,i)) >=10 && Integer.parseInt(s.substring(i-2,i))<=26)
                dp[i] += dp[i-2];
        }
        return dp[n];
    }
}
