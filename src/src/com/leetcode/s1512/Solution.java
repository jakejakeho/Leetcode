package src.com.leetcode.s1512;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3}));
    }

    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.putIfAbsent(num, 0);
            hashMap.put(num, hashMap.get(num) + 1);
        }
        int numOfPairs = 0;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            Integer size = entry.getValue();
            for (int i = 0; i < size; i++) {
                numOfPairs += size - i - 1;
            }
        }
        return numOfPairs;
    }
}