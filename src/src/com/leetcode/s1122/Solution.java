package src.com.leetcode.s1122;

import java.util.*;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> priorityMap = new HashMap<>();
        int arr2Length = arr2.length;
        for (int i = 0; i < arr2Length; i++) {
            priorityMap.put(arr2[i], i - arr2Length);
        }
        return Arrays.stream(arr1).boxed().sorted(Comparator.comparingInt(a -> priorityMap.getOrDefault(a, a))).mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6})));
    }
}