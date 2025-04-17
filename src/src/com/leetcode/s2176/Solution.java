package src.com.leetcode.s2176;
class Solution {

    public int countPairs(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (i != j && nums[i] == nums[j] && ((i * j) % k == 0)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countPairs(new int[] {3, 1, 2, 2, 2, 1, 3}, 2));
        System.out.println(solution.countPairs(new int[] {1, 2, 3, 4}, 1));
    }
}