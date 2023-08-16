package src.com.leetcode.s215;

import java.util.PriorityQueue;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findKthLargest(new int[] {3, 2, 1, 5, 6, 4}, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            priorityQueue.offer(num);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();
    }
}