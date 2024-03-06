package src.com.leetcode.s2002;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxProduct(String s) {
        int N = s.length();
        Map<Integer, Integer> palidroneLengtMap = new HashMap<>();
        for (Integer mask = 1; mask < 1 << N; mask++) {
            StringBuilder sb = new StringBuilder();
            for (Integer digit = 0; digit < N; digit++) {
                if ((mask & 1 << digit) != 0) {
                    sb.append(s.charAt(digit));
                }
            }
            String original = sb.toString();
            String reversed = sb.reverse().toString();
            if (original.equals(reversed)) {
                palidroneLengtMap.put(mask, original.length());
            }
        }

        int maxProduct = 0;
        for (Integer mask1 : palidroneLengtMap.keySet()) {
            for (Integer mask2 : palidroneLengtMap.keySet()) {
                if ((mask1 & mask2) == 0) {
                    maxProduct = Math.max(maxProduct, palidroneLengtMap.get(mask1) * palidroneLengtMap.get(mask2));
                }
            }
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProduct("leetcodecom"));
    }
}   