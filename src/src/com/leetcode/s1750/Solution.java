package src.com.leetcode.s1750;

class Solution {
    public int minimumLength(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int leftPointer = 0;
        int rightPointer = s.length() - 1;
        while (s.charAt(leftPointer) == s.charAt(rightPointer)) {
            char targetDeleteChar = s.charAt(leftPointer);
            while (s.charAt(leftPointer) == targetDeleteChar) {
                leftPointer++;
                if (leftPointer == rightPointer) {
                    if (s.charAt(leftPointer) == targetDeleteChar)
                        return 0;
                    else
                        return 1;
                }
            }
            while (s.charAt(rightPointer) == targetDeleteChar) {
                rightPointer--;
                if (leftPointer == rightPointer) {
                    if (s.charAt(rightPointer) == targetDeleteChar)
                        return 0;
                    else
                        return 1;
                }
            }
        }
        return rightPointer - leftPointer + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumLength("ca"));
        System.out.println(solution.minimumLength("cabaabac"));
    }
}