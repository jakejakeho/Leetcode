package src.com.leetcode.s1461;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean hasAllCodes(String s, int k) {
        double combinations = Math.pow(2, k);
        int possibility = s.length() - k + 1;
        if (combinations > possibility) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < k; i++) {
            stringBuilder.append('0');
        }
        Set<String> set = new HashSet<>();

        int carry = 0;
        set.add(stringBuilder.toString());
        for (int i = 0; i < combinations - 1; i++) {
            carry = 0;
            for (int j = stringBuilder.length() - 1; j >= 0; j--) {
                int sum;
                if (j == stringBuilder.length() - 1) {
                    sum = stringBuilder.charAt(j) - '0' + 1;
                } else {
                    sum = stringBuilder.charAt(j) - '0' + carry;
                }
                carry = sum >= 2 ? 1 : 0;
                stringBuilder.setCharAt(j, sum == 1 ? '1' : '0');
                if (carry == 0) {
                    break;
                }
            }
            set.add(stringBuilder.toString());
        }

        StringBuilder stringBuilder1 = new StringBuilder();
        for (int i = 0; i < k; i++) {
            stringBuilder1.append(s.charAt(i));
        }
        for (int i = 0; i <= s.length() - k; i++) {
            String test = stringBuilder1.toString();
            set.remove(test);
            if (set.isEmpty()) {
                return true;
            }
            stringBuilder1.deleteCharAt(0);
            if (i + k < s.length())
                stringBuilder1.append(s.charAt(i + k));
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hasAllCodes("00110110", 2));
    }
}