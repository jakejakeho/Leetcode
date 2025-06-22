package src.com.leetcode.s2138;
import java.util.Arrays;

class Solution {
    public String[] divideString(String s, int k, char fill) {
        int arrSize = Math.ceilDiv(s.length(), k);
        String[] result = new String[arrSize];
        char[] charArr = s.toCharArray();
        int charArrIndex = 0;
        for (int i = 0; i < arrSize; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < k; j++) {
                stringBuilder.append(charArr[charArrIndex++]);
                if (charArrIndex == s.length()) {
                    break;
                }
            }
            for (int j = stringBuilder.length(); j < k; j++) {
                stringBuilder.append(fill);
            }
            result[i] = stringBuilder.toString();
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution =new Solution();
        System.out.println(Arrays.toString(solution.divideString("abcdefghi", 3, 'x')));
        System.out.println(Arrays.toString(solution.divideString("abcdefghij", 3, 'x')));
    }
}