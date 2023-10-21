package src.com.leetcode.s7;
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(123));
        System.out.println(solution.reverse(-123));
        System.out.println(solution.reverse(120));
    }

    public int reverse(int x) {
        String str = String.valueOf(Math.abs(x));
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        if (x < 0) {
            sb.insert(0, "-");
        }
        int result = 0;
        try {
            result = Integer.parseInt(sb.toString());
        } catch (Exception e) {

        }
        return result;
    }
}