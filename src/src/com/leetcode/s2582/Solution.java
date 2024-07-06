package src.com.leetcode.s2582;

class Solution {
    public int passThePillow(int n, int time) {
        boolean isLeftToRight = (time / (n - 1)) % 2 == 0;
        int remain = time % (n - 1);
        return isLeftToRight ? remain + 1 : n - remain;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.passThePillow(4, 5));
        System.out.println(solution.passThePillow(3, 2));
        System.out.println(solution.passThePillow(9, 4));
    }
}