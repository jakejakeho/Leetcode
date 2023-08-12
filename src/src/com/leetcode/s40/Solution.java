package src.com.leetcode.s40;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum2(new int[] {10, 1, 2, 7, 6, 1, 5}, 8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> answer = new HashSet<>();
        Arrays.sort(candidates);
        recursive(candidates, target, answer, new ArrayList<>(), 0);
        return new ArrayList<>(answer);
    }

    private void recursive(int[] candidates, int target, Set<List<Integer>> answer, List<Integer> currentList,
                           int index) {
        if (target == 0) {
            Collections.sort(currentList);
            answer.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {continue;}
            if (target < candidates[i]) {break;}

            currentList.add(candidates[index]);
            recursive(candidates, target - candidates[i], answer, currentList, i + 1);
            currentList.remove(currentList.size() - 1);
        }
    }
}