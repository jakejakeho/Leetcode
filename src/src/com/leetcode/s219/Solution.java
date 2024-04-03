package src.com.leetcode.s219;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0;
        Set<Integer> set = new HashSet<>();
        for (int right = 0; right < nums.length; right++) {
            if (!set.add(nums[right])) {
                return true;
            }

            if (right >= k) {
                set.remove(nums[left++]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
    }
}