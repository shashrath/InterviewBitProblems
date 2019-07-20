package shasha.company.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeSumZero {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(-31013930, -31013930, 9784175, 21229755 ));
        System.out.println(threeSum(al));
    }
    private static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
         Collections.sort(nums);
        for (int i = 0; i + 2 < nums.size(); i++) {
            if (i > 0 && nums.get(i).equals(nums.get(i-1))){              // skip same result
                continue;
            }
            int j = i + 1, k = nums.size() - 1;
            int target = -nums.get(i);
            while (j < k) {
                if (nums.get(j) + nums.get(k) == target) {
                    res.add(new ArrayList<>(Arrays.asList(nums.get(i), nums.get(j), nums.get(k))));
                    j++;
                    k--;
                    while (j < k && nums.get(j) == nums.get(j-1)) j++;  // skip same result
                    while (j < k && nums.get(k) == nums.get(k+1)) k--;  // skip same result
                } else if (nums.get(j) + nums.get(k) > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
}
