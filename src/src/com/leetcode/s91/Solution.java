package src.com.leetcode.s91;
import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numDecodings("12"));
    }

    public int numDecodings(String s) {
        char[] sArr = s.toCharArray();
        int[] numOfWays = new int[s.length()];
        Arrays.fill(numOfWays, -1);
        return numDecodings(sArr, 0, numOfWays);
    }

    public int numDecodings(char[] sArr, int i, int[] numOfWaysCache) {
        if (i >= sArr.length) {
            return 0;
        }
        if (numOfWaysCache[i] != -1) {
            return numOfWaysCache[i];
        } else {
            int numOfWays = 0;
            if (isValid(sArr[i])) {
                if (i == sArr.length - 1) {
                    numOfWays++;
                } else {
                    numOfWays += numDecodings(sArr, i + 1, numOfWaysCache);
                }
            }
            if (i + 1 < sArr.length && isValid(sArr[i], sArr[i + 1])) {
                if (i == sArr.length - 2) {
                    numOfWays++;
                } else {
                    numOfWays += numDecodings(sArr, i + 2, numOfWaysCache);
                }
            }
            numOfWaysCache[i] = numOfWays;
            return numOfWays;
        }
    }

    public boolean isValid(char c) {
        return c >= '1' && c <= '9';
    }

    public boolean isValid(char c1, char c2) {
        return ((c1 == '1' && c2 >= '0' && c2 <= '9') || (c1 == '2' && c2 >= '0' && c2 <= '6'));
    }
}