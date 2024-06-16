package src.com.leetcode.s3186;

import java.util.*;

class Solution {

    private static class Spell {
        int power;
        long damageTotal;

        public Spell(int power, long damageTotal) {
            this.power = power;
            this.damageTotal = damageTotal;
        }

        public long getDamageTotal() {
            return damageTotal;
        }
    }

    public long maximumTotalDamage(int[] power) {
        // Frequency map to count the occurrences of each damage value
        Map<Integer, Long> freqMap = new HashMap<>();
        for (int p : power) {
            freqMap.put(p, freqMap.getOrDefault(p, 0L) + p);
        }

        // Extract unique damage values and sort them
        List<Integer> uniquePowers = new ArrayList<>(freqMap.keySet());
        Collections.sort(uniquePowers);

        // DP array to store maximum damage up to each unique damage value
        int n = uniquePowers.size();
        long[] dp = new long[n];

        // Initialize the dp array

        dp[0] = freqMap.get(uniquePowers.get(0));

        for (int i = 1; i < n; i++) {
            int currentPower = uniquePowers.get(i);
            long currentDamage = freqMap.get(currentPower);

            // Start with the previous maximum value
            dp[i] = dp[i - 1];

            // Check if we can take this power by looking for the nearest valid power
            int j = i - 1;
            while (j >= 0 && uniquePowers.get(j) >= currentPower - 2) {
                j--;
            }
            if (j >= 0) {
                dp[i] = Math.max(dp[i], currentDamage + dp[j]);
            } else {
                dp[i] = Math.max(dp[i], currentDamage);
            }
        }
        // The answer is the maximum value in the dp array

        return dp[n - 1];

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumTotalDamage(new int[]{1, 1, 3, 4}));
        System.out.println(solution.maximumTotalDamage(new int[]{7, 1, 6, 6}));
        Random rand = new Random();
        int[] longestTestCase = new int[10000];
        for (int i = 0; i < longestTestCase.length; i++) {
            longestTestCase[i] = 1 + rand.nextInt((int) Math.pow(10, 9));
        }
        System.out.println(solution.maximumTotalDamage(longestTestCase));
    }
}