package src.com.leetcode.s3304;

class Solution {
    public char kthCharacter(int k) {
        StringBuilder stringBuilder = new StringBuilder("a");
        while (stringBuilder.length() < k) {
            StringBuilder change = new StringBuilder(stringBuilder);
            for (int i = 0 ; i < change.length(); i++) {
                change.setCharAt(i, (char)(change.charAt(i) + 1));
            }
            stringBuilder.append(change);
        }
        return stringBuilder.charAt(k - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.kthCharacter(5));
        System.out.println(solution.kthCharacter(10));
    }
}