package src.com.leetcode.s22;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    final String LEFT_BRACKET = "(";
    final String RIGHT_BRACKET = ")";

    public List<String> generateParenthesis(int n) {
        if (n <= 0) return new ArrayList<>();
        List<String> results = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            // Add left


        }
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 3;
        System.out.println("Input: " + n);
        System.out.println("Output: " + solution.generateParenthesis(n));
    }
}
