package src.com.leetcode.s2348;

class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long result = 0;
        int pendingFactorial = 0;
        for (int num : nums) {
            if (num == 0) {
                pendingFactorial++;
            } else {
                result += numOfSubArrays(pendingFactorial);
                pendingFactorial = 0;
            }
        }
        if (pendingFactorial >= 0) {
            result += numOfSubArrays(pendingFactorial);
        }
        return result;
    }

    public long numOfSubArrays(int n) {
        return n * (n + 1L) / 2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.zeroFilledSubarray(new int[]{1, 3, 0, 0, 2, 0, 0, 4}));
    }
}