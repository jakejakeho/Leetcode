package src.com.leetcode.s658;

import java.util.*;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        LinkedList<Integer> result = new LinkedList<>();
        int diffSum = 0;
        for (int i = arr.length - 1; i >= arr.length - k; i--) {
            result.add(0, arr[i]);
            diffSum += Math.abs(arr[i] - x);
        }
        int left = arr.length - k - 1;
        int right = arr.length - 1;
        for (; left >= 0; left--) {
            int leftScore = Math.abs(arr[left] - x);
            int rightScore = Math.abs(arr[right] - x);
            int newDiffSum = diffSum - rightScore + leftScore;
            if (newDiffSum <= diffSum) {
                diffSum = newDiffSum;
                result.remove(result.size() - 1);
                right--;
                result.add(0, arr[left]);
            } else {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3));
        System.out.println(solution.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1));
        System.out.println(solution.findClosestElements(new int[]{0, 0, 1, 2, 3, 3, 4, 7, 7, 8}, 3, 5));
        System.out.println(solution.findClosestElements(new int[]{1, 1, 1, 10, 10, 10}, 1, 9));
    }
}