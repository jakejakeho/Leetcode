package src.com.leetcode.s35;

class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (right - left) / 2;
        while (right - left > 1) {
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                // go right;
                left = mid;
            } else {
                // go left
                right = mid;
            }
            mid = (right + left) / 2;
        }
        if (target > nums[right]) {
            return right + 1;
        }
        if (target <= nums[left]) {
            return left;
        }
        return right;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 5));
//        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 7));
    }
}