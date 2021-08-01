package shasha.company.practice;

public class NonDecreasingOrder {
    public static void main(String[] args) {
        int[] result = {4,2,3};
        checkPossibility(result);
    }

    public static boolean checkPossibility(int[] nums) {
        boolean flag = true;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] > nums[i+1]){
                if(!flag){
                    return false;
                }
                //First we'll check whether we can decrement the value
                if(i-1 < 0){ // previous value not present we can decrement
                    nums[i] = nums[i+1];
                    flag = false;
                }
                else if(nums[i-1] <= nums[i+1]){ // We can decrement the value to previous value.
                    nums[i] =  nums[i-1];
                    flag = false;
                }
                else if(i+2 >= nums.length){ // As it is the last element we can increment it.
                    nums[i+1] = nums[i];
                    return true;
                }
                else if(nums[i] <= nums[i+2]){
                    nums[i+1] = nums[i+2];
                    flag = false;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}
