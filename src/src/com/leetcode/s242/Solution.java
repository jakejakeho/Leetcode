package src.com.leetcode.s242;

public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] charCount = new int[26];
        for (char sChar : s.toCharArray()) {
            charCount[sChar - 'a']--;
        }

        for (char tChar : t.toCharArray()) {
            charCount[tChar - 'a']++;
        }

        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
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
