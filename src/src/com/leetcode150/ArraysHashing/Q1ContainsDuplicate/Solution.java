package src.com.leetcode150.ArraysHashing.Q1ContainsDuplicate;

import java.util.HashSet;
import java.util.Set;

class Solution {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.containsDuplicate(new int[] {1, 2, 3, 1}));
        System.out.println(solution.containsDuplicate(new int[] {1, 2, 3, 4}));
        System.out.println(solution.containsDuplicate(new int[] {1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }
}