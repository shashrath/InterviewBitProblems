package shasha.company.Backtracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationUnique {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        List<List<Integer>> result = permuteUnique(nums);
        System.out.println(result);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        permuteUniqueRecur(nums,temp,result,visited);
        return result;
    }
    public static void permuteUniqueRecur(int[]nums, List<Integer> temp, List<List<Integer>> result, boolean[] visited){
        if(temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i])
                continue;
            if(i-1>=0 && nums[i-1]==nums[i] && visited[i-1])
                continue;
            visited[i]=true;
            temp.add(nums[i]);
            permuteUniqueRecur(nums,temp,result,visited);
            visited[i]=false;
            temp.remove((Integer)nums[i]);
        }
    }
}
