package src.com.leetcode.s992;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int result = 0;
        int leftFar = 0;
        int leftNear = 0;
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int right = 0; right < nums.length; right++) {
            numMap.put(nums[right], numMap.getOrDefault(nums[right], 0) + 1);
            while (numMap.size() > k) {
                numMap.put(nums[leftNear], numMap.getOrDefault(nums[leftNear], 0) - 1);
                if (numMap.get(nums[leftNear]) == 0) {
                    numMap.remove(nums[leftNear]);
                }
                leftNear++;
                leftFar = leftNear;
            }
            while (numMap.getOrDefault(nums[leftNear], 0) > 1) {
                numMap.put(nums[leftNear], numMap.get(nums[leftNear]) - 1);
                leftNear++;
            }
            if (numMap.size() == k) {
                result += leftNear - leftFar + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2));
//        System.out.println(solution.subarraysWithKDistinct(new int[]{1, 2, 1, 3, 4}, 3));
//        System.out.println(solution.subarraysWithKDistinct(new int[]{2, 1, 1, 1, 2}, 1));
    }
}