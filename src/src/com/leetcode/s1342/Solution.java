package src.com.leetcode.s1342;

class Solution {
    public int numberOfSteps(int num) {
        int steps = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num--;
            }
            steps++;
        }
        return steps;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfSteps(14));
        System.out.println(solution.numberOfSteps(8));
        System.out.println(solution.numberOfSteps(123));
    }
}