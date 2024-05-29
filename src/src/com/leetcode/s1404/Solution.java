package src.com.leetcode.s1404;


class Solution {
    public int numSteps(String s) {
        int steps = 0;
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() > 1) {
            if (sb.charAt(sb.length() - 1) == '0') {
                // divided by 2
                // shift right
                sb.deleteCharAt(sb.length() - 1);
            } else {
                // plus 1
                int carry = 0;
                int index = sb.length() - 1;
                while (index >= 0 && (index == sb.length() - 1 || carry == 1)) {
                    int sum = sb.charAt(index) - '0' + carry;
                    if (index == sb.length() - 1) {
                        sum += 1;
                    }
                    sb.setCharAt(index, sum % 2 == 0 ? '0' : '1');
                    carry = sum >= 2 ? 1 : 0;
                    index--;
                }
                if (carry == 1) {
                    sb.insert(0, '1');
                }
            }
            steps++;
        }
        return steps;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSteps("1101"));
        System.out.println(solution.numSteps("10"));
        System.out.println(solution.numSteps("1"));
    }
}