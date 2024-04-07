package src.com.leetcode.s2215;

import java.util.*;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }
        List<Integer> list2 = new ArrayList<>();
        for (int num1 : set1) {
            if (!set2.contains(num1)) {
                list2.add(num1);
            }
        }
        List<Integer> list1 = new ArrayList<>();
        for (int num2 : set2) {
            if (!set1.contains(num2)) {
                list1.add(num2);
            }
        }
        return List.of(list2, list1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findDifference(new int[]{1, 2, 3}, new int[]{2, 4, 6}));
    }
}