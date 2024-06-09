package src.com.leetcode.s3176;

import java.util.*;

class Solution {
    public int maximumLength(int[] nums, int k) {
        return dfs(nums, k, new HashMap<>(), 0, -1);
    }

    private int dfs(int[] nums, int k, Map<Integer, Integer> countMap, int i, int notEqual) {
        if (i >= nums.length) {
            return 0;
        }
        int maxLength = 1;
        for (int j = i; j < nums.length; j++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
            System.out.println(countMap);
            if (countMap.size() <= k) {
                maxLength = Math.max(maxLength, 1 + dfs(nums, k, countMap, j + 1, notEqual + 1));
            }
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) - 1);
            if (countMap.get(nums[i]) == 0) {
                countMap.remove(nums[i]);
            }
            System.out.println(countMap);
            maxLength = Math.max(maxLength, dfs(nums, k, countMap, j + 1, notEqual));
        }
        return maxLength;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumLength(new int[]{1, 2, 1, 1, 3}, 2));
//        System.out.println(solution.maximumLength(new int[]{1, 2, 3, 4, 5, 1}, 0));
//        System.out.println(solution.maximumLength(new int[]{2}, 0));
//        System.out.println(solution.maximumLength(new int[]{1, 17}, 0));
    }
}