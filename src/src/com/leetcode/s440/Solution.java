package src.com.leetcode.s440;
class Solution {

    public int findKthNumber(int n, int k) {
        int current = 1;
        k--;
        while (k > 0) {
            int step = countSteps(n, current, current + 1);

            if (step <= k) {
                current++;
                k -= step;
            } else {
                current *= 10;
                k--;
            }
        }
        return current;
    }

    private int countSteps(int n, long prefix1, long prefix2) {
        int steps = 0;
        while (prefix1 <= n) {
            steps += Math.min(n + 1, prefix2) - prefix1;
            prefix1 *= 10;
            prefix2 *= 10;
        }
        return steps;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findKthNumber(1000000, 567));
    }
}