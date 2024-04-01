package src.com.leetcode.s189;



class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length == 1) {
            return;
        }
        k %= nums.length;
        int[] tempList = new int[k];
        int index = 0;
        for (int i = nums.length - k; i < nums.length; i++) {
            tempList[index] = nums[i];
            index++;
        }

        for (int i = nums.length - k - 1; i >= 0 ; i--) {
            nums[i + k] = nums[i];
        }

        for (int i = 0; i < k; i++) {
            nums[i] = tempList[i];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }
}