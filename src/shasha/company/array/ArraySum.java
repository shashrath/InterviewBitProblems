package shasha.company.array;

/*
Interview bit
Sign of the Product of an Array
*/
public class ArraySum {
    public static void main(String[] args) {
        int nums[] = {1,2,-3};
        int result = arraySign2(nums);
        System.out.println(result);
    }

    public static int arraySign(int[] nums) {
        Boolean positive = false;
        if (nums[0] == 0)
            return 0;
        else if (nums[0] > 0)
            positive = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0)
                return 0;
            else if (nums[i] > 0)
                positive = positive ^ true;
            else if (nums[i] < 0)
            positive = positive ^ false;
        }
        if (positive)
            return 1;
        else
            return -1;
    }
    
    public static int arraySign1(int[] nums){
        int count = 0;
        for(int i: nums){
            if(i ==0 )
                return 0;
            if(i < 0)
                count++;
        }
        return count%2==0?1:-1;
    }

    public static int arraySign2(int[] nums){
        int sign = 1;
        for(int i: nums){
            if(i == 0 )
                return 0;
            if(i < 0)
                sign = -sign;
        }
        return sign;
    }
    
}
