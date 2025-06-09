package src.com.leetcode.s43;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Solution {

    public String multiply(String num1, String num2) {
        if (Objects.equals(num1, "0") || Objects.equals(num2, "0")) {
            return "0";
        }
        List<StringBuilder> adds = new ArrayList<>();
        for (int j = 0; j < num2.length(); j++) {
            StringBuilder tmp = new StringBuilder();
            int zeros = num2.length() - j - 1;
            for (int z = 0; z < zeros; z++) {
                tmp.insert(0, '0');
            }
            char c2 = num2.charAt(j);
            int carry = 0;
            for (int i = num1.length() - 1; i >= 0; i--) {
                char c1 = num1.charAt(i);
                int n1 = c1 - '0';
                int n2 = c2 - '0';
                int result = n1 * n2 + carry;
                tmp.insert(0, (char)(result % 10 + '0'));
                carry = result / 10;
            }
            if (carry != 0)
                tmp.insert(0, (char)(carry + '0'));
            adds.add(tmp);
        }

        StringBuilder result = new StringBuilder("0");
        for (StringBuilder add : adds) {
            result = add(result, add);
        }
        return result.toString();
    }

    private StringBuilder add(StringBuilder s1, StringBuilder s2) {
        StringBuilder stringBuilder = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < Math.max(s1.length(), s2.length()); i++) {
            int n1 = 0;
            int n2 = 0;
            if ((s1.length() - i - 1) >= 0) {n1 = s1.charAt((s1.length() - i - 1)) - '0';}

            if ((s2.length() - i - 1) >= 0) {n2 = s2.charAt((s2.length() - i - 1)) - '0';}

            int result = n1 + n2 + carry;
            stringBuilder.insert(0, (char)(result % 10 + '0'));
            carry = result / 10;
        }
        if (carry != 0)
            stringBuilder.insert(0, (char)(carry + '0'));
        return stringBuilder;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.multiply("123", "456"));
        System.out.println(solution.multiply("2", "3"));
    }
}