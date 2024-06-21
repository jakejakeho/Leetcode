package src.com.leetcode.s1052;

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0)
                sum += customers[i];
        }
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1)
                sum += customers[i];
        }
        max = Math.max(sum, max);
        for (int i = 0; i < customers.length - minutes; i++) {
            if (grumpy[i] == 1) {
                sum -= customers[i];
            }
            if (grumpy[i + minutes] == 1) {
                sum += customers[i + minutes];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSatisfied(
                new int[]{1, 0, 1, 2, 1, 1, 7, 5},
                new int[]{0, 1, 0, 1, 0, 1, 0, 1},
                3
        ));
        System.out.println(solution.maxSatisfied(
                new int[]{1},
                new int[]{0},
                1
        ));
        System.out.println(solution.maxSatisfied(
                new int[]{10, 1, 7},
                new int[]{0, 0, 0},
                2
        ));
    }
}