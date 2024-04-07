package src.com.leetcode.s3106;

class Solution {
    public String getSmallestString(String s, int k) {
        if (k == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; k > 0 && i < s.length(); i++) {
            char c = s.charAt(i);
            for (char d = 'a'; (int) d < (int) c; d++) {
                int dist = distance(c, d);
                if (dist <= k) {
                    sb.setCharAt(i, d);
                    k -= dist;
                    break;
                }
            }
        }
        return sb.toString();
    }

    private int distance(char a, char b) {
        int aI = a - 'a';
        int bI = b - 'a';
        return Math.min((26 + bI - aI) % 26, (26 + aI - bI) % 26);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getSmallestString("xaxcd", 4));
    }
}