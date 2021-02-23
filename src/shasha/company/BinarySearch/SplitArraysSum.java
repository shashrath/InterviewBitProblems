package shasha.company.BinarySearch;

public class SplitArraysSum {
    public static void main(String[] args) {
        SplitArraysSum splitArraysSum = new SplitArraysSum();
        int[] nums = {7,2,5,10,8};
        System.out.println(splitArraysSum.splitArray(nums,2));
    }
    public int splitArray(int[] nums, int m) {
        int low =-1, high =0,mid=0;
        for(int i=0;i<nums.length;i++){
            if(low < nums[i])
                low = nums[i];
            high  += nums[i];
        }
        while(low<high){
            mid = (low+high)/2;
            if(checkPartition(mid, nums,m)){
                high = mid;
            }
            else
                low = mid+1;
        }
        return high;
    }
    public boolean checkPartition(int target, int[] nums, int m){
        int sum =0,count=0;
        for(int i=0;i< nums.length;i++){
            sum +=nums[i];
            if(sum>target){
                sum = nums[i];
                count++;
            }
        }
        count++;
        return count <= m;
    }
}
