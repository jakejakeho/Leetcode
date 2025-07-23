package src.com.leetcode.s1717;

class Solution {

    public int maximumGain(String s, int x, int y) {
        int totalScore = 0;
        StringBuilder sb = new StringBuilder(s);

        // Determine which substring to remove first based on point values
        if (x >= y) {
            // Remove "ab" first, then "ba"
            totalScore += removeSubstring(sb, "ab", x);
            totalScore += removeSubstring(sb, "ba", y);
        } else {
            // Remove "ba" first, then "ab"
            totalScore += removeSubstring(sb, "ba", y);
            totalScore += removeSubstring(sb, "ab", x);
        }
        return totalScore;
    }

    public int removeSubstring(StringBuilder sb, String pattern, int point) {
        int total = 0;
        StringBuilder stack = new StringBuilder();

        for (char c : sb.toString().toCharArray()) {
            stack.append(c);
            int len = stack.length();
            if (len >= 2
                && stack.charAt(len - 2) == pattern.charAt(0)
                && stack.charAt(len - 1) == pattern.charAt(1)) {
                stack.setLength(len - 2);
                total += point;
            }
        }

        sb.setLength(0);
        sb.append(stack);
        return total;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumGain("cdbcbbaaabab", 4, 5)); // Expected: 19
        System.out.println(solution.maximumGain("aabbaaxybbaabb", 5, 4)); // Expected: 20
        System.out.println(solution.maximumGain(
            "aabbrtababbabmaaaeaabeawmvaataabnaabbaaaybbbaabbabbbjpjaabbtabbxaaavsmmnblbbabaeuasvababjbbabbabbasxbbtgbrbbajeabbbfbarbagha",
            8484, 4096)); // Expected: large value
    }
}