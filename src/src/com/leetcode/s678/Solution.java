package src.com.leetcode.s678;

class Solution {
    public boolean checkValidString(String s) {
        int numOfOpenParenthesisMax = 0;
        int numOfOpenParenthesisMin = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                numOfOpenParenthesisMax++;
                numOfOpenParenthesisMin++;
            } else if (s.charAt(i) == ')') {
                numOfOpenParenthesisMax--;
                numOfOpenParenthesisMin--;
            } else {
                numOfOpenParenthesisMax++;
                numOfOpenParenthesisMin--;
            }
            if (numOfOpenParenthesisMax < 0) {
                return false;
            }
            if (numOfOpenParenthesisMin < 0) {
                numOfOpenParenthesisMin = 0;
            }
        }
        return numOfOpenParenthesisMin == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkValidString("()"));
        System.out.println(solution.checkValidString("(*)"));
        System.out.println(solution.checkValidString("(*))"));
        System.out.println(solution.checkValidString("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()"));
    }
}