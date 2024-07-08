package src.com.leetcode.s1662;
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int leftIndex = 0;
        int leftPointer = 0;
        int rightIndex = 0;
        int rightPointer = 0;
        while (leftIndex < word1.length && rightIndex < word2.length) {
            if (word1[leftIndex].charAt(leftPointer) != word2[rightIndex].charAt(rightPointer)) {
                return false;
            }
            leftPointer++;
            if (leftPointer >= word1[leftIndex].length()) {
                leftIndex++;
                leftPointer = 0;
            }
            rightPointer++;
            if (rightPointer >= word2[rightIndex].length()) {
                rightIndex++;
                rightPointer = 0;
            }

            if (leftIndex >= word1.length ^ rightIndex >= word2.length) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.arrayStringsAreEqual(new String[]{"ab", "c"}, new String[]{"a", "bc"}));
        System.out.println(solution.arrayStringsAreEqual(new String[]{"a", "cb"}, new String[]{"ab", "c"}));
        System.out.println(solution.arrayStringsAreEqual(new String[]{"abc", "d", "defg"}, new String[]{"abcdefg"}));
    }
}