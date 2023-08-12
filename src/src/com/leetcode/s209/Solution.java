package src.com.leetcode.s209;

class Solution {

    public Integer minLength = null;

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minSubArrayLen(7, new int[] {2, 3, 1, 2, 4, 3})); // 2
        System.out.println(solution.minSubArrayLen(213, new int[] {12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12})); // 8
    }

    public int minSubArrayLen(int target, int[] nums) {
        int min = 0;
        int leftPointer = 0;
        int rightPointer = 0;
        int currerntSum = 0;
        do {
            currerntSum += nums[rightPointer];
            if (currerntSum >= target) {
                while (currerntSum >= target) {
                    int size = rightPointer - leftPointer + 1;
                    if (min == 0) {min = size;} else {min = Math.min(min, size);}
                    currerntSum -= nums[leftPointer];
                    leftPointer++;
                }
            }
            rightPointer++;
        } while (rightPointer < nums.length);
        return min;
    }
}