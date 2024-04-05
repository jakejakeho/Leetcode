package src.com.leetcode.s1544;

class Solution {
    public String makeGood(String s) {
        for (int i = 0; i <= s.length() - 2; i++) {
            boolean iIsLowerCase = Character.isLowerCase(s.charAt(i));
            boolean nextIsUpperCase = Character.isLowerCase(s.charAt(i + 1));
            boolean isSameChar = Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(i + 1));
            if (isSameChar && iIsLowerCase ^ nextIsUpperCase) {
                s = s.substring(0, i) + s.substring(i + 2);
                i = -1;
            }
        }
        return s;
    }

    private boolean isLowerCase(char c) {
        return c >= 'a' && c <= 'z';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.makeGood("leEeetcode"));
        System.out.println(solution.makeGood("abBAcC"));
    }
}