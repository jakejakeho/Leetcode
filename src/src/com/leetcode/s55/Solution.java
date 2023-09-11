package src.com.leetcode.s55;
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canJump(new int[] {2, 3, 1, 1, 4}));
        System.out.println(solution.canJump(new int[] {3, 2, 1, 0, 4}));

    }

    public boolean canJump(int[] nums) {
        if (nums.length == 1) {return true;}
        int farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) {
                return false;
            }
            farthest = Math.max(farthest, i + nums[i]);

        }
        return true;
    }
}