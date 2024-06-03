package src.com.leetcode.s387;

class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        int[] index = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            index[s.charAt(i) - 'a'] = i;
        }

        int smallestIndex = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (count[i] == 1 && index[i] < smallestIndex) {
                smallestIndex = index[i];
            }
        }
        if (smallestIndex == Integer.MAX_VALUE) {
            return -1;
        }
        return smallestIndex;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstUniqChar("leetcode"));
        System.out.println(solution.firstUniqChar("loveleetcode"));
        System.out.println(solution.firstUniqChar("aabb"));
    }
}