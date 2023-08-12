package src.com.leetcode.s1218;
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestSubsequence(new int[] {1, 5, 7, 8, 5, 3, 4, 2, 1}, -2));
    }

    public int longestSubsequence(int[] arr, int difference) {
        int longest = 0;
        int[] countArr = new int[20001];
        for (int leftPointer = 0; leftPointer < arr.length; leftPointer++) {
            int num = arr[leftPointer];
            int key = num + 10000;
            int lastKey = key - difference;
            if (lastKey >= 0 && lastKey <= 20000) {
                countArr[key] = countArr[lastKey] + 1;
            } else {
                countArr[key] = 1;
            }
            longest = Math.max(countArr[key], longest);
        }
        return longest;
    }
}