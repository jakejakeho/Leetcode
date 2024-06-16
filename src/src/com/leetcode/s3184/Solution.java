package src.com.leetcode.s3184;


class Solution {
    public int countCompleteDayPairs(int[] hours) {
        for (int i = 0; i < hours.length; i++) {
            hours[i] %= 24;
        }
        int pairs = 0;
        for (int i = 0; i < hours.length; i++) {
            for (int j = i + 1; j < hours.length; j++) {
                int sum = hours[i] + hours[j];
                if (sum == 0 || sum == 24) {
                    pairs++;
                }
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countCompleteDayPairs(new int[]{12, 12, 30, 24, 24}));
        System.out.println(solution.countCompleteDayPairs(new int[]{72, 48, 24, 3}));
        System.out.println(solution.countCompleteDayPairs(new int[]{21, 19, 3}));
    }
}