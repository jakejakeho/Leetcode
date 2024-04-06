package src.com.leetcode.s1249;

class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] charArr = s.toCharArray();
        int open = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else if (s.charAt(i) == ')') {
                if (open > 0) {
                    open--;
                } else {
                    charArr[i] = '*';
                }
            }
        }
        for (int i = charArr.length - 1; open > 0 && i >= 0; i--) {
            if (charArr[i] == '(') {
                charArr[i] = '*';
                open--;
            }
        }

        int index = 0;
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] != '*')
                charArr[index++] = charArr[i];
        }
        return new String(charArr).substring(0, index);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(solution.minRemoveToMakeValid("a)b(c)d"));
        System.out.println(solution.minRemoveToMakeValid("))(("));
    }
}