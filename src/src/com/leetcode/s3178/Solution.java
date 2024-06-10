package src.com.leetcode.s3178;

class Solution {
    public int numberOfChild(int n, int k) {
        int currentIndex = 0;
        boolean leftToRight = false;
        while (k > 0) {
            if (currentIndex == n - 1 || currentIndex == 0) {
                leftToRight = !leftToRight;
            }
            if (leftToRight) {
                currentIndex++;
            } else {
                currentIndex--;
            }
            k--;
        }
        return currentIndex;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfChild(3, 5));
        System.out.println(solution.numberOfChild(5, 6));
        System.out.println(solution.numberOfChild(4, 2  ));
    }
}