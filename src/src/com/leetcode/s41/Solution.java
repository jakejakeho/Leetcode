package src.com.leetcode.s41;

class Solution {
    public int firstMissingPositive(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 1 && nums[i] <= nums.length && nums[i] != (i + 1) && nums[nums[i] - 1] != nums[i]) {
                temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
                i--;
            }
        }


        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != (i + 1)) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(solution.firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(solution.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        System.out.println(solution.firstMissingPositive(new int[]{1, 1}));
    }
}