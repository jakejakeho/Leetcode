package src.com.leetcode.s1209;

class Solution {
    public String removeDuplicates(String s, int k) {
        char[] stack = new char[s.length()];
        int stackIndex = -1;
        int count = 1;
        char[] sArr = s.toCharArray();
        for (char c : sArr) {
            if (stackIndex != -1) {
                if (c == stack[stackIndex]) {
                    count++;
                } else {
                    count = 1;
                }
            }
            stack[++stackIndex] = c;
            while (count == k) {
                stackIndex -= k;
                for (int temp = stackIndex + 1; temp <= stackIndex + k; temp++) {
                    stack[temp] = '\u0000';
                }
                if (stackIndex < 0) {
                    count = 1;
                    stackIndex = -1;
                    break;
                }
                char currentTop = stack[stackIndex];
                int tempIndex = stackIndex;
                count = 0;
                while (tempIndex >= 0 && stack[tempIndex] == currentTop) {
                    count++;
                    tempIndex--;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder(stackIndex + 1);
        for (int i = 0; i <= stackIndex; i++) {
            stringBuilder.append(stack[i]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates("abcd", 2));
        System.out.println(solution.removeDuplicates("deeedbbcccbdaa", 3));
        System.out.println(solution.removeDuplicates("pbbcggttciiippooaais", 2));
    }
}