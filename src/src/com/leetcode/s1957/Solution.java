package src.com.leetcode.s1957;
class Solution {

    public String makeFancyString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] sArr = s.toCharArray();
        char lastChar = (char)((int)sArr[0] + 1);
        int count = 1;
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] != lastChar) {
                count = 0;
            } else {
                count++;
                if (count >= 2) {
                    continue;
                }
            }
            lastChar = sArr[i];
            stringBuilder.append(sArr[i]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.makeFancyString("leeetcode"));
        System.out.println(solution.makeFancyString("aaabaaaa"));
        System.out.println(solution.makeFancyString("aab"));
    }
}