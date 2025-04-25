package src.com.leetcode150.T3_SlidingWindow.Q6_SlidingWindowMaximum;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {return nums;}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int left = 0;
        int right = 0;
        int[] result = new int[nums.length - k + 1];
        while (right < nums.length) {
            int[] element = new int[] {right, nums[right]};
            pq.offer(element);
            if (right >= k - 1) {
                while (pq.peek()[0] <= right - k) {
                    pq.poll();
                }
                result[left++] = pq.peek()[1];
            }
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[] {7, 2, 4}, 2)));
        //System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[] {9, 8, 9, 8}, 3)));
    }
}