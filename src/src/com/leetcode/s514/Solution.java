package src.com.leetcode.s514;


import java.util.Arrays;

class Solution {
    public int findRotateSteps(String ring, String key) {
        int[] curr = new int[ring.length()];
        int[] prev = new int[ring.length()];

        for (int r = 0; r < ring.length(); r++) {
            prev[r] = 0;
        }
        for (int k = key.length() - 1; k >= 0; k--) {
            Arrays.fill(curr, Integer.MAX_VALUE);
            for (int r = 0; r < ring.length(); r++) {
                for (int r2 = 0; r2 < ring.length(); r2++) {
                    if (ring.charAt(r2) == key.charAt(k)) {
                        int clockwise = Math.abs(r - r2);
                        int antiClockwise = ring.length() - clockwise;
                        int min = Math.min(clockwise, antiClockwise);
                        curr[r] = Math.min(curr[r], 1 + min + prev[r2]);
                    }
                }
            }
            prev = curr.clone();
        }
        return prev[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findRotateSteps("godding", "gd"));
        System.out.println(solution.findRotateSteps("godding", "godding"));
        System.out.println(solution.findRotateSteps("edcba", "abcde"));
        System.out.println(solution.findRotateSteps("ababcab", "acbaacba"));
    }
}