package src.com.leetcode.s1;


import java.util.Arrays;
import java.util.List;

public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        List<Integer> sorted = Arrays.stream(nums).boxed().sorted().toList();

        // skip last
        for (int i = 0; i < sorted.size() - 1; i++) {
            for (int j = i + 1; j < sorted.size(); j++) {
                Integer firstValue = sorted.get(i);
                Integer secondValue = sorted.get(j);
                if ((firstValue + secondValue) == target) {
                    // Find first Value index
                    Integer firstIndex = getIndexByValue(nums, firstValue, -1);
                    Integer secondIndex = getIndexByValue(nums, secondValue, firstIndex);

                    return new int[]{ firstIndex, secondIndex };
                }
            }
        }

        return new int[]{};
    }

    private Integer getIndexByValue(int[] nums, Integer value, Integer skipIndex) {
        for (int k = 0; k < nums.length; k++) {
            if (k != skipIndex && nums[k] == value) {
                return k;
            }
        }
        return null;
    }
}
