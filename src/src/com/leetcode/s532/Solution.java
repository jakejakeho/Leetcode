package src.com.leetcode.s532;

import java.util.HashMap;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int prefixMod = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            prefixMod = (prefixMod + num) % k;

            if (hashMap.containsKey(prefixMod)) {
                if (i - hashMap.get(prefixMod) > 1) {
                    return true;
                }
            } else {
                hashMap.put(prefixMod, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
        System.out.println(solution.checkSubarraySum(new int[]{23, 2, 4, 6, 6}, 7));
        System.out.println(solution.checkSubarraySum(new int[]{0}, 1));
    }
}