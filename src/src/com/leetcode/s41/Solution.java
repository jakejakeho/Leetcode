package src.com.leetcode.s41;

class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 || nums[i] > nums.length + 1) {
                nums[i] = 0;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1)
                continue;
            int index = nums[i] - 1;
            if (index < 0 || index >= nums.length)
                continue;
            if (nums[index] > 0) {
                nums[i] = nums[index];
                i--;
            }
            nums[index] = -1;
        }

        int smallest = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                smallest++;
            } else {
                break;
            }
        }
        return smallest;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.firstMissingPositive(new int[]{1, 2, 0}));

//        System.out.println(solution.firstMissingPositive(new int[]{3, 4, -1, 1}));

        System.out.println(solution.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }
}