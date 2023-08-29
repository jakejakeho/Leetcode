package src.com.leetcode;
class Solution {

    public int countSubstrings(String s) {
        int countSubstrings = 0;

        char[] sArr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;
            while (left >= 0 && right < s.length() && sArr[left] == sArr[right]) {
                countSubstrings++;
                left--;
                right++;
            }

            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && sArr[left] == sArr[right]) {
                countSubstrings++;
                left--;
                right++;
            }
        }
        return countSubstrings;
    }
}