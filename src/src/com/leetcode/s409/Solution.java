package src.com.leetcode.s409;

class Solution {
    public int longestPalindrome(String s) {
        int[] countMap = new int[200];
        for (int i = 0; i < s.length(); i++) {
            countMap[s.charAt(i)]++;
        }

        int longest = 0;
        boolean hasSingleChar = false;
        for (int i = 0; i < countMap.length; i++) {
            if (countMap[i] > 0) {
                longest += (countMap[i] / 2) * 2;
                hasSingleChar |= countMap[i] % 2 == 1;
            }
        }
        longest += hasSingleChar ? 1 : 0;
        return longest;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("abccccdd"));
        System.out.println(solution.longestPalindrome("a"));
    }
};
