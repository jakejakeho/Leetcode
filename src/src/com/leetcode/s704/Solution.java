package src.com.leetcode.s704;
public class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test case 1
        int[] nums = new int[]{ -1, 0, 3, 5, 9, 12 };
        int target = 9;
        int result = solution.search(nums, target);
        int excepted = 4;
        System.out.println("Test case 1, result = " + result + "Excepted = " + excepted + " correct? = " + (result == excepted));

        // test case 2
        nums = new int[]{ -1, 0, 3, 5, 9, 12 };
        target = 2;
        result = solution.search(nums, target);
        excepted = -1;
        System.out.println("Test case 2, result = " + result + "Excepted = " + excepted + " correct? = " + (result == excepted));
    }
}
