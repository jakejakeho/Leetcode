package src.com.leetcode150.T3_SlidingWindow.Q3_LongestRepeatingCharacterReplacement;
import java.util.Map;

class Solution {

    public int characterReplacement(String s, int k) {
        int longest = 0;
        int left = 0;
        int right = 0;
        int[] countMap = new int[26];
        int max = 0;
        while (right < s.length()) {
            countMap[s.charAt(right) - 'A']++;
            max = Math.max(max, countMap[s.charAt(right) - 'A']);
            if (right - left + 1 - max > k) {
                countMap[s.charAt(left) - 'A']--;
                left++;
            }
            longest = Math.max(longest, right - left + 1);
            right++;
        }
        return longest;
    }

    private boolean isValid(Map<Character, Integer> map, int k, int length) {
        int larger = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            larger = Math.max(larger, entry.getValue());
        }
        return (length - larger) <= k;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.characterReplacement("ABAB", 2));
        System.out.println(solution.characterReplacement("AABABBA", 1));
    }
}