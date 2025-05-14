package src.com.leetcode.s3335;

class Solution {

    private static final long MOD_CONSTANT = (long) Math.pow(10, 9) + 7;

    public int lengthAfterTransformations(String s, int t) {
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
                long countMod = count % MOD_CONSTANT;
                if (i + 1 == 26) {
                    newCountMap[0] += countMod;
                    newCountMap[1] += countMod;
                } else {
                    newCountMap[(i + 1)] += countMod;
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
        System.out.println(solution.lengthAfterTransformations("abcyy", 2));
    }
}