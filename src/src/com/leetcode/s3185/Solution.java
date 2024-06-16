package src.com.leetcode.s3185;


class Solution {
    public long countCompleteDayPairs(int[] hours) {
        long[] count = new long[24];
        for (int hour : hours) {
            count[hour % 24]++;
        }
        long pairs = 0;
        for (int i = 0; i <= count.length / 2; i++) {
            if (i == 0 || i == 12) {
                pairs += (count[i] * (count[i] - 1)) / 2;
            } else {
                pairs += (count[i] * count[24 - i]);
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.countCompleteDayPairs(new int[]{12, 12, 30, 24, 24}));
//        System.out.println(solution.countCompleteDayPairs(new int[]{72, 48, 24, 3}));
        System.out.println(solution.countCompleteDayPairs(new int[]{1,1,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}));
    }
}