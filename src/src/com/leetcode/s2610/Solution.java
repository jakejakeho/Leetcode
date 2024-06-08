package src.com.leetcode.s2610;

import java.util.*;

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int remaining = nums.length;
        boolean[] done = new boolean[nums.length];
        List<List<Integer>> lists = new ArrayList<>();
        while (remaining > 0) {
            Set<Integer> set = new HashSet<>();
            List<Integer> currentList = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (!done[i] && !set.contains(num)) {
                    set.add(num);
                    currentList.add(num);
                    done[i] = true;
                    remaining--;
                }
            }
            lists.add(currentList);
        }
        return lists;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMatrix(new int[]{1, 3, 4, 1, 2, 3, 1}));
    }
}