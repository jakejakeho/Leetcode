package src.com.leetcode.s2441;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> positiveSet = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            if (num > 0) {
                positiveSet.add(num);
            }
        }

        int maxK = -1;
        for (int num : positiveSet) {
            if (num > maxK && set.contains(-num)) {
                maxK = num;
            }
        }
        return maxK;
    }
}