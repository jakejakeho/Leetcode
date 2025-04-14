package src.com.leetcode.s1752;
class Solution {

    public boolean check(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min) {
                min = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == min) {
                boolean result = myCheck(nums, i);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean myCheck(int[] nums, int startIndex) {
        int last = nums[startIndex % nums.length];
        for (int i = 1; i < nums.length; i++) {
            int current = nums[(i + startIndex) % nums.length];
            if (current < last) {
                return false;
            } else {
                last = current;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.check(new int[] {3, 4, 5, 1, 2}));
        System.out.println(solution.check(new int[] {2, 1, 3, 4}));
        System.out.println(solution.check(new int[] {1, 2, 3}));
        System.out.println(solution.check(new int[] {6, 10, 6}));
    }
}