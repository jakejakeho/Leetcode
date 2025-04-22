package src.com.leetcode.s2381;
class Solution {

    public String shiftingLetters(String s, int[][] shifts) {
        int[] finalShift = new int[s.length()];
        for (int i = 0; i < shifts.length; i++) {
            int[] shift = shifts[i];
            int start = shift[0];
            int end = shift[1];
            boolean isForward = shift[2] == 1;
            finalShift[start] += isForward ? 1 : -1;
            if (end + 1 < s.length()) {
                finalShift[end + 1] += isForward ? -1 : 1;
            }
        }

        StringBuilder sb = new StringBuilder(s);
        int numberOfShifts = 0;
        for (int i = 0; i < s.length(); i++) {
            numberOfShifts = numberOfShifts + finalShift[i] % 26;
            if (numberOfShifts < 0) {
                numberOfShifts += 26;
            }
            int a = sb.charAt(i) - 'a' + (numberOfShifts);
            if (a < 0) {
                a = (a % 26 + 26) % 26;
            }
            if (a >= 26) {
                a %= 26;
            }
            sb.setCharAt(i, (char)('a' + a));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.shiftingLetters("abc", new int[][] {{0, 1, 0}, {1, 2, 1}, {0, 2, 1}}));
        System.out.println(solution.shiftingLetters("dztz", new int[][] {{0, 0, 0}, {1, 1, 1}}));
    }
}