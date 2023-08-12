package src.com.leetcode.draft;


import java.util.HashMap;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        int longest = 0;
        for (int num : nums) {
            hashMap.put(num, true);
        }
        for (int num: nums) {
            int count = 0;
            if (!hashMap.containsKey(num - 1)) {
                while (hashMap.containsKey(num++)) {
                    count++;
                }
                longest = Math.max(count, longest);
            }
        }
        return longest;
    }
}