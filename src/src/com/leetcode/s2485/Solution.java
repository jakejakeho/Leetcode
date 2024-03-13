package src.com.leetcode.s2485;

class Solution {
    public int pivotInteger(int n) {
        int prefix = (n * (n + 1)) / 2;

        int suffix = 0;
        for (int i = n; i >= 1; i--) {
            suffix += i;
            if (prefix == suffix) {
                return i;
            } else if (prefix < suffix) {
                return -1;
            }
            prefix -= i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pivotInteger(8));
    }
}