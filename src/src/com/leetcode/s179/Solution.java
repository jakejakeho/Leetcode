package src.com.leetcode.s179;

import java.util.Arrays;

class Solution {

    public String largestNumber(int[] nums) {
        String[] sorts = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sorts[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(sorts, (a, b) -> {
            String str1 = a + b;
            String str2 = b + a;
            return str2.compareTo(str1);
        });

        if (sorts[0].equals("0")) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        for (String sort : sorts) {
            result.append(sort);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestNumber(new int[]{10, 2}));
        System.out.println(solution.largestNumber(new int[]{3, 30, 34, 5, 9}));
    }
}