package src.com.leetcode.s3211;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        recursive(n, sb, result);
        return result;
    }

    private void recursive(int n,StringBuilder sb, List<String> result) {
        if (sb.length() == n) {
            if (sb.length() < 2 || sb.charAt(sb.length() - 1) == '1' || sb.charAt(sb.length() - 2) == '1')
                result.add(sb.toString());
            return;
        }
        if (sb.length() <= 1 || sb.charAt(sb.length() - 1) == '1' || sb.charAt(sb.length() - 2) == '1') {
            sb.append('1');
            recursive(n, sb, result);
            sb.deleteCharAt(sb.length() - 1);
            sb.append('0');
            recursive(n, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validStrings(3));
        System.out.println(solution.validStrings(1));
    }
}