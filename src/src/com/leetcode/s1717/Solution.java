package src.com.leetcode.s1717;

class Solution {
    public int maximumGain(String s, int x, int y) {
        int maxGain = 0;
        int abIndex = -1;
        int baIndex = -1;
        StringBuilder sb = new StringBuilder(s);
        for (int i = sb.length() - 2; i >= 0; i--) {
            if (sb.charAt(i) == 'a' && sb.charAt(i) == 'b') {
                abIndex = i;
            } else if (sb.charAt(i) == 'b' && sb.charAt(i) == 'a') {
                baIndex = i;
            }
            if (x == y) {
                if (abIndex != -1) {
                    sb.deleteCharAt(abIndex);
                    sb.deleteCharAt(abIndex);
                    maxGain += x;
                    abIndex = -1;
                    baIndex = -1;
                } else if (baIndex != -1) {
                    sb.deleteCharAt(baIndex);
                    sb.deleteCharAt(baIndex);
                    maxGain += y;
                    abIndex = -1;
                    baIndex = -1;
                }
            } else if (x > y) {

            }
        }
        return maxGain;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumGain("cdbcbbaaabab", 4, 5));
        System.out.println(solution.maximumGain("aabbaaxybbaabb", 5, 4));
    }
}