package src.com.leetcode.s678;


class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkValidString("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()"));
    }

    public boolean checkValidString(String s) {
        int leftMin = 0;
        int leftMax = 0;
        char[] charArr = s.toCharArray();
        for (char c : charArr) {
            if (c == '(') {
                leftMin++;
                leftMax++;
            } else if (c == ')') {
                leftMin--;
                leftMax--;
            } else {
                leftMin--;
                leftMax++;
            }
            if (leftMax < 0) {
                return false;
            }
            if (leftMin < 0)
                leftMin = 0;
        }
        return leftMin == 0;
    }
}