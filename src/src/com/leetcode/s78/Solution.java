package src.com.leetcode.s78;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subsets(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets(nums, subsets, new ArrayList<>(), 0);
        return subsets;
    }

    private void subsets(int[] nums, List<List<Integer>> subsets, List<Integer> currentList, int currentIndex) {
        if (currentIndex >= nums.length) {
            subsets.add(new ArrayList<>(currentList));
            return;
        }
        // add this num
        currentList.add(nums[currentIndex]);
        subsets(nums, subsets, currentList, currentIndex + 1);
        // don't add this num
        currentList.remove(currentList.size() - 1);
        subsets(nums, subsets, currentList, currentIndex + 1);
    }
}