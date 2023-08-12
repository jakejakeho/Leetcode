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
        combinationSum(candidates, target, result, new ArrayList<>(), 0);
        return result;
    }

    private void combinationSum(int[] candidates, int target, List<List<Integer>> result, List<Integer> currentList,
                                int currentIndex) {
        int sum = 0;
        for (Integer integer : currentList) {
            sum += integer;
        }
        if (sum == target) {
            result.add(new ArrayList<>(currentList));
        }

        if (currentIndex >= candidates.length)
            return;
        // add this num;
        currentList.add(candidates[currentIndex]);
        combinationSum(candidates, target, result, currentList, currentIndex + 1);
        // don't add this num
        currentList.remove(Integer.valueOf(candidates[currentIndex]));
        combinationSum(candidates, target, result, currentList, currentIndex + 1);
    }
}