package src.com.leetcode150.T5_BinarySearch.Q1_BinarySearch;
import java.awt.image.WritableRaster;

class Solution {

    /**
     * Code Testcase Test Result Test Result 704. Binary Search Solved Easy Topics premium lock icon Companies Given an
     * array of integers nums which is sorted in ascending order, and an integer target, write a function to search
     * target in nums. If target exists, then return its index. Otherwise, return -1.
     * <p>
     * You must write an algorithm with O(log n) runtime complexity.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [-1,0,3,5,9,12], target = 9 Output: 4 Explanation: 9 exists in nums and its index is 4 Example 2:
     * <p>
     * Input: nums = [-1,0,3,5,9,12], target = 2 Output: -1 Explanation: 2 does not exist in nums so return -1
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 104 -104 < nums[i], target < 104 All the integers in nums are unique.
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            int midValue = nums[mid];
            if (midValue == target) {
                return mid;
            } else if (midValue < target) {
                // go left
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[] {-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(solution.search(new int[] {-1, 0, 3, 5, 9, 12}, 2));
        System.out.println(solution.search(new int[] {5}, 5));
    }
}