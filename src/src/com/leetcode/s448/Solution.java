package src.com.leetcode.s448;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] existsMap = new boolean[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            existsMap[nums[i]] = true;
        }
        List<Integer> missingList = new ArrayList<>();
        for (int i = 1; i < existsMap.length; i++) {
            if (!existsMap[i])
                missingList.add(i);
        }
        return missingList;
    }
}