package src.com.leetcode.s1717;

class Solution {

    public int maximumGain(String s, int x, int y) {
        int totalScore = 0;
        StringBuilder sb = new StringBuilder(s);

        char[][] checkLogics = x >= y ? new char[][] {{'a', 'b'}, {'b', 'a'}} : new char[][] {{'b', 'a'}, {'a', 'b'}};

        for (int i = 0; i < sb.length() - 1; i++) {
            char firstChar = checkLogics[0][0];
            char secondChar = checkLogics[0][1];
            if (sb.charAt(i) == firstChar && sb.charAt(i + 1) == secondChar) {
                totalScore += Math.max(x, y);
                sb.deleteCharAt(i);
                sb.deleteCharAt(i);
                i = Math.max(-1, i - 2);
            }

        }

        for (int i = 0; i < sb.length() - 1; i++) {
            char firstChar = checkLogics[1][0];
            char secondChar = checkLogics[1][1];
            if (sb.charAt(i) == firstChar && sb.charAt(i + 1) == secondChar) {
                totalScore += Math.min(x, y);
                sb.deleteCharAt(i);
                sb.deleteCharAt(i);
                i = Math.max(-1, i - 2);
            }
        }
        return totalScore;
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