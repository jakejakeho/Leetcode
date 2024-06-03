package src.com.leetcode.s349;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        Set<Integer> intersection = new HashSet<>();
        for (int j = 0; j < nums2.length; j++) {
            if (set.contains(nums2[j])) {
                intersection.add(nums2[j]);
            }
        }

        int[] ans = new int[intersection.size()];
        int index = 0;
        for (int num : intersection) {
            ans[index++] = num;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(solution.intersection(new int[]{9, 4}, new int[]{9, 4, 9, 8, 4})));
    }
}