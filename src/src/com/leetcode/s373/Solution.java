package src.com.leetcode.s373;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparing(nums -> nums.stream().mapToInt(Integer::intValue).sum()));
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                priorityQueue.offer(List.of(nums1[i], nums2[j]));
            }
        }

        List<List<Integer>> result = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            List<Integer> pair = priorityQueue.poll();
            if (pair != null)
                result.add(pair);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.kSmallestPairs(new int[] {1, 7, 11}, new int[] {2, 4, 6}, 3));
    }
}