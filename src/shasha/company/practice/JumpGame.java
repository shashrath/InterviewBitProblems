package shasha.company.practice;

import java.util.Arrays;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums  = {2,3,1,1,4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        int len = nums.length;
        int minSteps[] = new int[len];
        Arrays.fill(nums,Integer.MAX_VALUE);
        minSteps[0] = 0;
        for(int i=0;i<len;i++){
            int val = Math.min(nums[i]+i,len-1);
            for(int k=i+1;k<=val;k++){
                minSteps[k]= Math.min(minSteps[k],minSteps[i]+1);
            }
        }
        return minSteps[len-1];
    }
}
