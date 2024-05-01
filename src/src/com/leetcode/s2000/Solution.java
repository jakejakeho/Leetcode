package src.com.leetcode.s2000;

class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder stringBuilder = new StringBuilder();
        int index = word.indexOf(ch);
        return index != -1 ? new StringBuilder(word.substring(0, index + 1)).reverse().append(word.substring(index + 1)).toString() : word;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reversePrefix("abcdefd", 'd'));
        System.out.println(solution.reversePrefix("xyxzxe", 'z'));
        System.out.println(solution.reversePrefix("abcd", 'z'));
    }
}