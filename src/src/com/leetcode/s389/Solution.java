package src.com.leetcode.s389;
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTheDifference("abcd", "abcde"));
    }

    public char findTheDifference(String s, String t) {
        int[] countS = new int[26];
        int[] countT = new int[26];
        for (int i = 0; i < s.length(); i++) {
            countS[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            countT[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (countS[i] != countT[i]) {
                return (char)((int)'a' + i);
            }
        }
        return ' ';
    }
}