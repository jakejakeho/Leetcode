package src.com.leetcode.s1291;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList();
        double digits = Math.log10(low);
        int interval = (int)Math.pow(10, digits);
        for (int start = low; start <= high; start += Math.pow(10, (int)Math.log10(start))) {
            int expectedDigits = (int)Math.log10(start);
            int firstDigit = start / (int)Math.pow(10, expectedDigits);
            int num = 0;
            if (firstDigit + expectedDigits > 9) {
                continue;
            }
            int count = 0;
            for (int i = firstDigit; i <= firstDigit + expectedDigits ; i++) { 
                num += i * Math.pow(10, expectedDigits - count);
                count++;
            }
            if (num >= low && num <= high)
                result.add(num);
        }
        return result;
    }
}