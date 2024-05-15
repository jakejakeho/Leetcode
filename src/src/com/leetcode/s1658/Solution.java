package src.com.leetcode.s1658;

class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum < x)
            return -1;
        int target = sum - x;

        int currentSum = 0;
        int maxLeft = -1;
        int maxRight = -1;
        int left = 0;
        int right = 0;
        while (left <= right && right < nums.length) {
            currentSum += nums[right];
            while (currentSum > target) {
                currentSum -= nums[left];
                left++;
            }

            if (currentSum == target) {
                int length = (right - left + 1);
                int currentLength = (maxRight - maxLeft + 1);
                if (maxLeft == -1 || length > currentLength) {
                    maxLeft = left;
                    maxRight = right;
                }
            }
            right++;
        }

        if (maxLeft == -1) {
            return -1;
        }
        return nums.length - (maxRight - maxLeft + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minOperations(new int[]{1, 1, 4, 2, 3}, 5));
        System.out.println(solution.minOperations(new int[]{5, 6, 7, 8, 9}, 4));
        System.out.println(solution.minOperations(new int[]{3, 2, 20, 1, 1, 3,}, 10));
        System.out.println(solution.minOperations(new int[]{5, 2, 3, 1, 1,}, 5));
        System.out.println(solution.minOperations(new int[]{1, 1,}, 3));
    }
}