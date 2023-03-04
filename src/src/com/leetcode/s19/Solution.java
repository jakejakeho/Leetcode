package src.com.leetcode.s19;

import src.com.leetcode.s206.ListNode;

import java.util.List;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyPointer = null;
        ListNode leftPointer = head;
        ListNode rightPointer = head;
        for (int i = 0; i < n; i++) {
            rightPointer = rightPointer.next;
        }

        while (rightPointer != null) {
            dummyPointer = leftPointer;
            leftPointer = leftPointer.next;
            rightPointer = rightPointer.next;
        }
        if (dummyPointer == null && leftPointer.next == null) {
            return null;
        } else if (dummyPointer == null && leftPointer.next != null) {
            return leftPointer.next;
        } else if (dummyPointer != null && leftPointer != null) {
            dummyPointer.next = leftPointer.next;
            return head;
        }
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();


        ListNode head = null, result = null;
        int n = 0;
        /*
         * Input: head = [1,2,3,4,5], n = 2
         * Output: [1,2,3,5]
         */
        head = new ListNode(List.of(1, 2, 3, 4, 5));
        n = 2;
        System.out.println("Input: head = " + head + ", n = " + n);
        result = solution.removeNthFromEnd(head, n);
        System.out.println("Output: " + result);

        /*
         * Input: head = [1], n = 1
         * Output: []
         */
        head = new ListNode(List.of(1));
        n = 1;
        System.out.println("Input: head = " + head + ", n = " + n);
        result = solution.removeNthFromEnd(head, n);
        System.out.println("Output: " + result);

        /*
         * Input: head = [1,2], n = 2
         * Output: [2]
         */
        head = new ListNode(List.of(1, 2));
        n = 2;
        System.out.println("Input: head = " + head + ", n = " + n);
        result = solution.removeNthFromEnd(head, n);
        System.out.println("Output: " + result);
    }
}
