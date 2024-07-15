package src.com.leetcode.s3216;

class Solution {
    public String getSmallestString(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        for (int i = 0; i < stringBuilder.length() - 1; i++) {
            char firstChar = stringBuilder.charAt(i);
            char secondChar = stringBuilder.charAt(i + 1);
            if (firstChar > secondChar) {
                boolean sameParity = ((firstChar - '0') % 2 == 0) == ((secondChar - '0') % 2 == 0);
                if (sameParity) {
                    char temp = stringBuilder.charAt(i + 1);
                    stringBuilder.setCharAt(i + 1, stringBuilder.charAt(i));
                    stringBuilder.setCharAt(i, temp);
                    break;
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getSmallestString("45320"));
        System.out.println(solution.getSmallestString("001"));
    }
}