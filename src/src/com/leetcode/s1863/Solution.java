package src.com.leetcode.s1863;

class Solution {

    public int subsetXORSum(int[] nums) {
        return xorSum(nums, 0, 0);
    }

    private int xorSum(int[] nums, int index, int currentSum) {
        if (index == nums.length) {
            return currentSum;
        }

        int includeThis = xorSum(nums, index + 1, currentSum ^ nums[index]);

        int notIncludeThis = xorSum(nums, index + 1, currentSum);

        return includeThis + notIncludeThis;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subsetXORSum(new int[] {1, 3}));
        System.out.println(solution.subsetXORSum(new int[] {5, 1, 6}));
    }
}