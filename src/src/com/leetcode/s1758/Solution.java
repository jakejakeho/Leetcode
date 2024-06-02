package src.com.leetcode.s1758;

class Solution {
    public int minOperations(String s) {
        int oddCount = 0;
        int evenCount = 0;
        for (int i = 0; i < s.length(); i++) {
            boolean isOne = s.charAt(i) == '1';
            boolean isOdd = i % 2 == 1;
            // expect index 0 is 1
            if (!isOdd) {
                if (!isOne) {
                    oddCount++;
                } else {
                    evenCount++;
                }
            } else {
                // expect index 0 is 0
                if (isOne) {
                    oddCount++;
                } else {
                    evenCount++;
                }
            }
        }
        return Math.min(oddCount, evenCount);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minOperations("0100"));
    }
}