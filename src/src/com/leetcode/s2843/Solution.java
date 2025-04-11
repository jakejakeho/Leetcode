package src.com.leetcode.s2843;

class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int total = 0;
        // 10-99
        for (int i = Math.max(10, low); i <= Math.min(99, high); i++) {
            int left = i / 10;
            int right = i % 10;
            if (left == right) {
                total++;
            }
        }
        // 1000-9999
        for (int i = Math.max(1000, low); i <= Math.min(9999, high); i++) {
            int left = i / 100;
            int right = i % 100;
            left = sumOfDigits(left);
            right = sumOfDigits(right);
            if (left == right) {
                total++;
            }
        }
        return total;
    }

    private int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countSymmetricIntegers(1200,1230));
    }
}