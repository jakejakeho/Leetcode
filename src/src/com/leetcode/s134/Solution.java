package src.com.leetcode.s134;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println("expected = 3 result = " + solution.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        System.out.println("expected = -1 result = " + solution.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGasGain = 0;
        int defiency = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            int gasGain = gas[i] - cost[i];
            totalGasGain += gasGain;
            if (totalGasGain < 0) {
                defiency += totalGasGain;
                start = i + 1;
                totalGasGain = 0;
            }
        }

        if (defiency + totalGasGain >= 0)
            return start;
        return -1;
    }
}