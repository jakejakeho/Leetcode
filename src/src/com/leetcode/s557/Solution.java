package src.com.leetcode.s557;

class Solution {
    public String reverseWords(String s) {
        int lastSpaceIndex = -1;
        char[] arr = s.toCharArray();

        for (int i = 0; i <= arr.length; i++) {
            if (i == arr.length || arr[i] == ' ') {
                int startIndex = lastSpaceIndex + 1;
                int endIndex = i - 1;
                swap(arr, startIndex, endIndex);
                lastSpaceIndex = i;
            }
        }

        return new String(arr);
    }

    private void swap(char[] arr, int startIndex, int endIndex) {
        while (startIndex <= endIndex) {
            char temp = arr[startIndex];
            arr[startIndex] = arr[endIndex];
            arr[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("Let's take LeetCode contest"));
        System.out.println(solution.reverseWords("Mr Ding"));
    }
}