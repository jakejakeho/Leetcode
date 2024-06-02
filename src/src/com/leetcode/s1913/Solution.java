package src.com.leetcode.s1913;


class Solution {
    public int maxProductDifference(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }

            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        return (max1 * max2) - (min1 * min2);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProductDifference(new int[]{5, 6, 2, 7, 4}));
        System.out.println(solution.maxProductDifference(new int[]{4, 2, 5, 9, 7, 4, 8}));
    }
}