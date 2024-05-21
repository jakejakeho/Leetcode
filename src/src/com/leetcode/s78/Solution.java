package src.com.leetcode.s78;
import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        backTracking(nums, 0, result, currentList);
        return result;
    }

    private void backTracking(int[] nums, int i, List<List<Integer>> result, List<Integer> currentList) {
        if (i >= nums.length) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        // not include this index
        backTracking(nums, i + 1, result, currentList);

        // include this index
        currentList.add(nums[i]);
        backTracking(nums, i + 1, result, currentList);
        currentList.remove(currentList.size() - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subsets(new int[] {1, 2, 3}));
    }
}