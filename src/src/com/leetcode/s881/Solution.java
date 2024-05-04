package src.com.leetcode.s881;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int person : people) {
            map.put(person, map.getOrDefault(person, 0) + 1);
        }
    }
}