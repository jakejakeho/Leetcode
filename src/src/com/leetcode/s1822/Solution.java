package src.com.leetcode.s1822;

class Solution {
    public int arraySign(int[] nums) {
        int numOfNegative = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                numOfNegative++;
            } else if (nums[i] == 0) {
                return 0;
            }
        }
        return numOfNegative % 2 == 0 ? 1 : -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.arraySign(new int[]{-1, -2, -3, -4, 3, 2, 1}));

    }
}