package shasha.company.dynamicprogramming;

public class CardCount {

    public static void main(String[] args) {
        int[] nums = {9,7,7,9,7,7,9};
        maxScore(nums,7);
    }

    public static int maxScore(int[] card, int k) {
        int len = card.length;
        int dp[][] = new int[len][len];
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                dp[i][j] = -1;
            }
        }
        return maxScoreUtil(card,0,card.length-1,k,0,dp);
    }
    public static int maxScoreUtil(int[]card, int i, int j, int k, int sum, int dp[][]){
        if(k == 0){
            dp[i][j] = sum;
            return sum;
        }
        else{
            if(dp[i+1][j] == -1){
                dp[i+1][j] = maxScoreUtil(card,i+1,j,k-1, sum+ card[i],dp);
            }
            if(dp[i][j-1] == -1){
                dp[i][j-1] = maxScoreUtil(card,i,j-1,k-1, sum+ card[j],dp);
            }
            dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
            return dp[i][j];
        }
    }
}
