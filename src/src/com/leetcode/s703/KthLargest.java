package src.com.leetcode.s703;

import java.util.PriorityQueue;

public class KthLargest {

    private final int k;
    private final PriorityQueue<Integer> priorityQueue;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        priorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            this.add(num);
        }
    }

    public int add(int val) {
        if (priorityQueue.size() < k)
            priorityQueue.offer(val);
        else if (val > priorityQueue.peek()) {
            priorityQueue.poll();
            priorityQueue.add(val);
        }
        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));   // return 4
        System.out.println(kthLargest.add(5));   // return 5
        System.out.println(kthLargest.add(10));  // return 5
        System.out.println(kthLargest.add(9));   // return 8
        System.out.println(kthLargest.add(4));   // return 8
    }
}
