package src.com.leetcode.s168;

class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        while (columnNumber > 0) {
            int remainder = columnNumber % 26;
            if (remainder == 0) {
                remainder = 26;
            }
            columnNumber -= remainder;
            columnNumber /= 26;
            result.insert(0, (char) ('A' + remainder - 1));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        System.out.println(solution.convertToTitle(1));
//        System.out.println(solution.convertToTitle(28));
        System.out.println(solution.convertToTitle(701));
    }
}