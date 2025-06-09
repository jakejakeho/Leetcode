package src.com.leetcode.s3337;

import java.util.List;

class Solution {

    private static final long MOD_CONSTANT = (long) Math.pow(10, 9) + 7;

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        long[] countMap = new long[26];
        for (int i = 0; i < s.length(); i++) {
            countMap[s.charAt(i) - 'a']++;
        }
        while (t > 0) {
            long[] newCountMap = new long[26];
            for (int i = 0; i < 26; i++) {
                long count = countMap[i];
                if (count <= 0) {
                    continue;
                }
                int consecutive = nums.get(i);
                for (int j = 0; j < consecutive; j++) {
                    newCountMap[(i + j + 1) % 26] += count;
                    newCountMap[(i + j + 1) % 26] %= MOD_CONSTANT;
                }
            }
            countMap = newCountMap;
            t--;
        }
        long total = 0;
        for (int i = 0; i < 26; i++) {
            total += countMap[i];
            total %= MOD_CONSTANT;
        }
        return Math.toIntExact(total);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthAfterTransformations("abcyy", 2, List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2)));
    }
}