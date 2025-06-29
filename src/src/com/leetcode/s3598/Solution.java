package src.com.leetcode.s3598;

import java.util.Arrays;

class Solution {
    public int[] longestCommonPrefix(String[] words) {
        if (words.length <= 1) {
            return new int[words.length];
        }

        int[] commonLength = new int[words.length - 1];
        for (int i = 0; i + 1 < words.length; i++) {
            commonLength[i] = getCommonLength(words[i], words[i + 1]);
        }

        int[] prefix = new int[words.length - 1];
        int[] suffix = new int[words.length - 1];
        prefix[0] = commonLength[0];
        for (int i = 1; i < commonLength.length - 1; i++) {
            prefix[i] = Math.max(prefix[i - 1], commonLength[i]);
        }

        suffix[words.length - 2] = commonLength[words.length - 2];
        for (int i = words.length - 3; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i + 1], commonLength[i]);
        }

        int[] ans = new int[words.length];
        for (int i = words.length - 1; i >= 0; i--) {
            int best = 0;
            if (i >= 2) {
                best = Math.max(best, prefix[i - 2]);
            }
            if (i + 1 <= words.length - 2) {
                best = Math.max(best, suffix[i + 1]);
            }
            if (i > 0 && i < words.length - 1) {
                best = Math.max(best, getCommonLength(words[i - 1], words[i + 1]));
            }
            ans[i] = best;
        }
        return ans;
    }

    public int getCommonLength(String s1, String s2) {
        int length = 0;
        int smaller = Math.min(s1.length(), s2.length());
        for (int i = 0; i < smaller; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                break;
            }
            length++;
        }
        return length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.longestCommonPrefix(new String[]{"jump", "run", "run", "jump", "run"})));
        System.out.println(Arrays.toString(solution.longestCommonPrefix(new String[]{"dog", "racer", "car"})));
    }
}