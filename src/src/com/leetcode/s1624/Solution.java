package src.com.leetcode.s1624;

import java.util.Arrays;

class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int maxLength = -1;
        int[] index = new int[26];
        Arrays.fill(index, -1);
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (index[c] == -1) {
                index[c] = i;
            } else {
                maxLength = Math.max(maxLength, i - index[c] - 1);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxLengthBetweenEqualCharacters("aa"));
        System.out.println(solution.maxLengthBetweenEqualCharacters("abca"));
        System.out.println(solution.maxLengthBetweenEqualCharacters("cbzxy"));
        System.out.println(solution.maxLengthBetweenEqualCharacters("cabbac"));
    }
}