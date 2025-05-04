package src.com.leetcode.s1128;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int total = 0;
        Map<String, Integer> count = new HashMap<>();
        for (int[] domino : dominoes) {
            String key = domino[0] <= domino[1] ? domino[0] + "-" + domino[1] : domino[1] + "-" + domino[0];
            Integer original = count.getOrDefault(key, 0);
            total += original;
            count.put(key, original + 1);
        }
        return total;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numEquivDominoPairs(new int[][]{{1, 2}, {2, 1}, {3, 4}, {5, 6}}));
        System.out.println(solution.numEquivDominoPairs(new int[][]{{1, 2}, {1, 2}, {1, 1}, {1, 2}, {2, 2}}));
    }
}