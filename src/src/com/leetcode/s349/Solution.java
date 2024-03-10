package src.com.leetcode.s349;

import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1Map = new HashSet<>();
        for (int num1: nums1) {
            nums1Map.add(num1);
        }

        Set<Integer> intersection = new HashSet<>();
        for (int num2: nums2) {
            if (nums1Map.contains(num2))
            intersection.add(num2);
        }

        int[] intersectionArr = new int[intersection.size()];
        int count = 0;
        for(int ele : intersection) {
            intersectionArr[count++] = ele;
        }
        return intersectionArr;
    }
}