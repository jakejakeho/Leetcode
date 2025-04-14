package src.com.leetcode.s3151;
class Solution {

    public boolean isArraySpecial(int[] nums) {
        boolean lastIsOdd = nums[0] % 2 == 1;
        for (int i = 1; i < nums.length; i++) {
            boolean currentIsOdd = nums[i] % 2 == 1;
            if (lastIsOdd == currentIsOdd) {
                return false;
            }
            lastIsOdd = currentIsOdd;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isArraySpecial(new int[] {1}));
        System.out.println(solution.isArraySpecial(new int[] {2, 1, 4}));
        System.out.println(solution.isArraySpecial(new int[] {4, 3, 1, 6}));
    }
}