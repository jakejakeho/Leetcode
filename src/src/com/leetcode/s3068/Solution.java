package src.com.leetcode.s3068;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long sum = 0;
        int[] diffMap = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            diffMap[i] = (nums[i] ^ k) - nums[i];
        }
        Arrays.sort(diffMap);
        for (int i = nums.length - 1; i >= 0; i -= 2) {
            if (i - 1 == -1) {
                break;
            }
            long pairSum = diffMap[i] + diffMap[i - 1];
            if (pairSum > 0) {
                sum += pairSum;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(
            solution.maximumValueSum(new int[] {24, 78, 1, 97, 44}, 6, new int[][] {{0, 2}, {1, 2}, {4, 2,}, {3, 4,}}));
    }
}