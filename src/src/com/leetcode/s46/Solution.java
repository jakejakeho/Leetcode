package src.com.leetcode.s46;
import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.permute(new int[] {0, 1}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        recursive(nums, answer, new ArrayList<>(), used);
        return answer;
    }

    public void recursive(int[] nums, List<List<Integer>> answer, List<Integer> currentList, boolean[] used) {
        if (currentList.size() == nums.length) {
            answer.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                currentList.add(nums[i]);
                used[i] = true;
                recursive(nums, answer, currentList, used);
                used[i] = false;
                currentList.remove(Integer.valueOf(nums[i]));
            }
        }
    }
}