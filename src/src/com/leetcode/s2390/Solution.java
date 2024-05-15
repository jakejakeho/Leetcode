package src.com.leetcode.s2390;


class Solution {
    public String removeStars(String s) {
        int len = s.length();
        byte[] bytes = new byte[len];
        s.getBytes(0, len, bytes, 0);
        int index = 0;
        for (byte ch : bytes) {
            if (ch == '*')
                index--;
            else
                bytes[index++] = ch;
        }
        return new String(bytes, 0, index);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeStars("leet**cod*e"));
        System.out.println(solution.removeStars("erase*****"));
    }
}