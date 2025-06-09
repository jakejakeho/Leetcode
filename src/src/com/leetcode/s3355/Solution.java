package src.com.leetcode.s3355;
class Solution {

    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] sum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum[i] = (i - 1 >= 0 ? sum[i - 1] : 0) + nums[i];
        }

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int start = query[0];
            int end = query[1];
            int s = sum[end] - (start == 0 ? 0 : sum[start]);
            if (s > Math.max((end - start), 2)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isZeroArray(new int[] {1, 0, 1}, new int[][] {{0, 2}}));
        System.out.println(solution.isZeroArray(new int[] {4, 3, 2, 1}, new int[][] {{1, 3}, {0, 2}}));
        System.out.println(solution.isZeroArray(new int[] {2}, new int[][] {{0,0}, {0, 0}}));
    }
}