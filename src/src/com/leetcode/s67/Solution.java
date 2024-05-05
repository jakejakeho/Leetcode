package src.com.leetcode.s67;
class Solution {

    public String addBinary(String a, String b) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum;
            if (i >= 0 && j >= 0) {
                sum = a.charAt(i) - '0' + b.charAt(j) - '0' + carry;
            } else if (i >= 0) {
                sum = a.charAt(i) - '0' + carry;
            } else {
                sum = b.charAt(j) - '0' + carry;
            }
            stringBuffer.insert(0, sum % 2);
            carry = sum == 2 ? 1 : 0;
            i--;
            j--;
        }
        if (carry == 1) {
            stringBuffer.insert(0, 1);
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("11", "1"));
    }
}