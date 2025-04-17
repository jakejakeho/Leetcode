package src.com.leetcode.s409;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int longest = 0;
        boolean hasSingleChar = false;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                hasSingleChar = true;
            }
            longest += entry.getValue() / 2 * 2;
        }
        return longest + (hasSingleChar ? 1 : 0);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("abccccdd"));
        System.out.println(solution.longestPalindrome("a"));
    }
}