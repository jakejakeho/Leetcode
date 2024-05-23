package src.com.leetcode.s2597;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution {

    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int index = 0;
        Map<Integer, Integer> currentSet = new HashMap<>();
        int[] result = new int[] {0};
        backtracking(nums, k, index, currentSet, result);
        return result[0];
    }

    private void backtracking(int[] nums, int k, int index, Map<Integer, Integer> currentMap, int[] result) {
        if (index >= nums.length) {
            if (!currentMap.isEmpty())
                result[0]++;
            return;
        }

        // add current number
        if (!currentMap.containsKey(nums[index] - k)) {
            currentMap.put(nums[index], currentMap.getOrDefault(nums[index], 0) + 1);
            backtracking(nums, k, index + 1, currentMap, result);
            currentMap.put(nums[index], currentMap.get(nums[index]) - 1);
            if (currentMap.get(nums[index]) == 0) {
                currentMap.remove(nums[index]);
            }
        }

        // not add current number
        backtracking(nums, k, index + 1, currentMap, result);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.beautifulSubsets(new int[] {2, 4, 6}, 2));
        System.out.println(solution.beautifulSubsets(new int[] {1}, 1));
    }
}