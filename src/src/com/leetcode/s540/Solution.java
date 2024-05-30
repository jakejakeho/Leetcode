package src.com.leetcode.s540;

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            boolean leftLengthIsOdd = (mid + 1) % 2 == 1;
            boolean isDuplicate = (mid + 1 < nums.length && nums[mid] == nums[mid + 1]) || (mid - 1 >= 0 && nums[mid] == nums[mid - 1]);
            if (!isDuplicate) {
                return nums[mid];
            }

            boolean goLeft = (leftLengthIsOdd && (mid - 1 >= 0 && nums[mid] == nums[mid - 1]))
                    || (!leftLengthIsOdd && (mid + 1 < nums.length && nums[mid] == nums[mid + 1]));

            if (goLeft) {
                // go left
                right = mid - 1;
            } else
                left = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        System.out.println(solution.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
    }
}