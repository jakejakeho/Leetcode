package src.com.leetcode.s403;

import java.util.HashMap;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
    }

    public boolean canCross(int[] stones) {
        Boolean [][] memo = new Boolean[stones.length+1][stones.length+1];
        HashMap<Integer, Integer> stoneMap = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            int stone = stones[i];
            stoneMap.put(stone, i);
        }
        return dfs(stoneMap, 1, 0, stones, memo);
    }

    public boolean dfs(HashMap<Integer, Integer> stoneMap, int k, int i, int[] stones, Boolean[][] memo) {
        if (i == stones.length - 1) {
            return true;
        }
        if (memo[k][i]!=null) {
            return memo[k][i];
        }
        List<Integer> kList;
        if (i == 0) {
            kList = List.of(1);
        } else {
            if (k - 1 > 0) {
                kList = List.of(k - 1, k, k + 1);
            } else {
                kList = List.of(k, k + 1);
            }
        }
        boolean isPossible = false;
        for (int possibleK : kList) {
            if (stoneMap.containsKey(stones[i] + possibleK)) {
                isPossible |= dfs(stoneMap, possibleK, stoneMap.get(stones[i] + possibleK), stones, memo);
            }
        }
        memo[k][i] = isPossible;
        return isPossible;
    }
}