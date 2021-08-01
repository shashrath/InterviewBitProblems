package shasha.company.practice;

public class NonOverlapping {
    public static void main(String[] args) {
        int num[] = {-1,3,5,1,4,2,-8};
        int target = 6;
        int result = someMethod(num,target);
        System.out.println(result);
    }

    public static int someMethod(int[] nums, int target){
        int N = nums.length;
        int[] dp = new int[N + 1];

        for (int i = 0; i < N; ++i) {

            int sum = 0;
            for (int j = i; j >= 0; --j) {
                sum += nums[j];
                dp[i + 1] = Math.max(dp[i + 1], dp[j] + (sum == target ? 1 : 0));
            }
        }

        return dp[N];
    }
}
