package src.com.leetcode150.T3_SlidingWindow.Q5_MinimumWindowSubstring;
import java.awt.image.ImageProducer;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public String minWindow(String s, String t) {
        Map<Character, Integer> tCount = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tCount.put(t.charAt(i), tCount.getOrDefault(t.charAt(i), 0) + 1);
        }
        int minStartId = -1;
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int match = 0;
        for (int right = 0; right < s.length(); right++) {
            if (tCount.containsKey(s.charAt(right))) {
                tCount.put(s.charAt(right), tCount.get(s.charAt(right)) - 1);
                if (tCount.get(s.charAt(right)) == 0) {
                    match++;
                }
            }

            while (match == tCount.size()) {
                int length = right - left + 1;
                if (length < minLength) {
                    minStartId = left;
                    minLength = length;
                }
                char deleted = s.charAt(left++);
                if (tCount.containsKey(deleted)) {
                    if (tCount.get(deleted) == 0) {match--;}
                    tCount.put(deleted, tCount.get(deleted) + 1);
                }
            }
        }
        return minStartId == -1 ? "" : s.substring(minStartId, minStartId + minLength);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
        //System.out.println(solution.minWindow("a", "a"));
        //System.out.println(solution.minWindow("a", "aa"));
        System.out.println(solution.minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));
    }
}