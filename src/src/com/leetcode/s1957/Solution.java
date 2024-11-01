package src.com.leetcode.s1957;
class Solution {

    /**
     * 1957. Delete Characters to Make Fancy String
     * Easy
     * Topics
     * Companies
     * Hint
     * A fancy string is a string where no three consecutive characters are equal.
     *
     * Given a string s, delete the minimum possible number of characters from s to make it fancy.
     *
     * Return the final string after the deletion. It can be shown that the answer will always be unique.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "leeetcode"
     * Output: "leetcode"
     * Explanation:
     * Remove an 'e' from the first group of 'e's to create "leetcode".
     * No three consecutive characters are equal, so return "leetcode".
     * Example 2:
     *
     * Input: s = "aaabaaaa"
     * Output: "aabaa"
     * Explanation:
     * Remove an 'a' from the first group of 'a's to create "aabaaaa".
     * Remove two 'a's from the second group of 'a's to create "aabaa".
     * No three consecutive characters are equal, so return "aabaa".
     * Example 3:
     *
     * Input: s = "aab"
     * Output: "aab"
     * Explanation: No three consecutive characters are equal, so return "aab".
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 105
     * s consists only of lowercase English letters.
     * @param s
     * @return
     */
    public String makeFancyString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        char c = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            } else {
                count = 1;
                c = s.charAt(i);
            }
            if (count <= 2) {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.makeFancyString("leeetcode"));
    }
}