package src.com.leetcode.s242;

public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] sCount = new int[26];
        int[] tCount = new int[26];
        for (int i = 0 ;i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
        }
        for (int i = 0 ;i < t.length(); i++) {
            tCount[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < sCount.length; i++) {
            if (sCount[i] != tCount[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "anagram";
        String t = "nagaram";

        System.out.println("Input: s = \"" + s + "\", t = \"" + t + "\"\nOutput: " + solution.isAnagram(s, t));
    }
}
