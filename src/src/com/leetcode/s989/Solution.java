package src.com.leetcode.s989;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {

    public List<Integer> addToArrayForm(int[] num, int k) {
        char[] kStr = String.valueOf(k)
                            .toCharArray();
        int[] kNum = new int[kStr.length];

        for (int i = 0; i < kStr.length; i++) {
            kNum[i] = kStr[i] - '0';
        }

        Stack<Integer> stack = new Stack<>();
        int i = num.length - 1;
        int j = kNum.length - 1;
        int lastCarry = 0;
        while (i >= 0 || j >= 0) {
            if (i >= 0 && j >= 0) {
                int sum = num[i] + kNum[j] + lastCarry;
                stack.add(sum % 10);
                lastCarry = sum >= 10 ? 1 : 0;
            } else if (i >= 0) {
                int sum = num[i] + lastCarry;
                stack.add(sum % 10);
                lastCarry = sum >= 10 ? 1 : 0;
            } else {
                int sum = kNum[j] + lastCarry;
                stack.add(sum % 10);
                lastCarry = sum >= 10 ? 1 : 0;
            }
            i--;
            j--;
        }

        if (lastCarry == 1) {
            stack.add(1);
        }

        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addToArrayForm(new int[] {9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1));
    }
}