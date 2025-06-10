package src.com.leetcode.s3442;

class Solution {
    public int maxDifference(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int oddMax = Integer.MIN_VALUE;
        int evenMin = Integer.MAX_VALUE;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                continue;
            }
            if (count[i] % 2 == 0) {
                //even
                if (count[i] < evenMin) {
                    evenMin = count[i];
                }
            } else {
                // odd
                if (count[i] > oddMax) {
                    oddMax = count[i];
                }
            }
        }

        return oddMax - evenMin;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxDifference("aaaaabbc"));
        System.out.println(solution.maxDifference("abcabcab"));
        System.out.println(solution.maxDifference("tzt"));
    }
}