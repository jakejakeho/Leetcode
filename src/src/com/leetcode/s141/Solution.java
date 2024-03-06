package src.com.leetcode.s141;

import src.com.leetcode.s206.ListNode;

import java.util.*;

public class Solution {

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
       ListNode fastPointer = head.next;
       ListNode slowPointer = head;
       while (fastPointer != null && slowPointer != null) {
           if (fastPointer.next == null) {
               break;
           }
           fastPointer = fastPointer.next.next;
           slowPointer = slowPointer.next;
           if (fastPointer == slowPointer) {
               return true;
           }
       }
       return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = null;

        /**
         * Input: head = [3,2,0,-4], pos = 1
         * Output: true
         * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
         */
        head = new ListNode(List.of(3, 2, 0, -4));
        boolean result = solution.hasCycle(head);
        System.out.println("Expected = True Result = " + result);
    }
}
