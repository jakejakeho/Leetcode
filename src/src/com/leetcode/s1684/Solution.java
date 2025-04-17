package src.com.leetcode.s1684;
class Solution {

    public int countConsistentStrings(String allowed, String[] words) {
        int[] allowedArr = new int[26];
        for (int i = 0; i < allowed.length(); i++) {
            char c = allowed.charAt(i);
            allowedArr[c - 'a'] = 1;
        }

        int count = 0;
        for (String word : words) {
            boolean isValid = true;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (allowedArr[c - 'a'] == 0) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countConsistentStrings("ab", new String[] {"ad", "bd", "aaab", "baa", "badab"}));
        System.out.println(
            solution.countConsistentStrings("abc", new String[] {"a", "b", "c", "ab", "ac", "bc", "abc"}));
        System.out.println(
            solution.countConsistentStrings("cad", new String[] {"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"}));
    }
}