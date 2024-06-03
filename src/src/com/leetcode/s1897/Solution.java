package src.com.leetcode.s1897;

class Solution {
    public boolean makeEqual(String[] words) {
        int[] count = new int[26];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                count[words[i].charAt(j) - 'a']++;
            }
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] % words.length != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.makeEqual(new String[]{"abc", "cba"}));
        System.out.println(solution.makeEqual(new String[]{"abc", "aabc", "bc"}));
        System.out.println(solution.makeEqual(new String[]{"ab", "a"}));
    }
}