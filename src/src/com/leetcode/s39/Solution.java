package src.com.leetcode.s39;
import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum(new int[] {2, 3, 6, 7}, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(candidates, target, result, new ArrayList<>(), 0, 0);
        return result;
    }

    private void combinationSum(int[] candidates, int target, List<List<Integer>> result, List<Integer> currentList,
                                int total, int currentIndex) {
        if (target == total) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        if (total > target || currentIndex >= candidates.length) {return;}

        // include this value
        int candidate = candidates[currentIndex];
        currentList.add(candidate);
        combinationSum(candidates, target, result, currentList, total + candidate, currentIndex);

        // don't include this value
        currentList.remove(Integer.valueOf(candidate));
        combinationSum(candidates, target, result, currentList, total, currentIndex + 1);
    }
}