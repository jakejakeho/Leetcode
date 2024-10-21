package src.com.leetcode.s673;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

class Solution {

    public int findNumberOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][2];
        for (int i = nums.length - 1; i >= 0; i--) {
            Map<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
            for (int j = i; j < nums.length; j++) {
                map.put(dp[j][0], map.getOrDefault(dp[j][0], 0) + dp[j][1]);
            }
            Map.Entry<Integer, Integer> lts = null;
            for (Map.Entry<Integer, Integer> longest : map.entrySet()) {
                lts = longest;
            }
            System.out.println(lts);
            if (lts == null) {
                dp[i][0] = 1;
                dp[i][1] = 1;
            } else {
                dp[i][0] = lts.getKey() + 1;
                dp[i][1] = lts.getValue();
            }
        }
        return dp[0][1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findNumberOfLIS(new int[] {1, 3, 5, 4, 7}));
        System.out.println(solution.findNumberOfLIS(new int[] {2, 2, 2, 2, 2}));
    }
}