package src.com.leetcode.s2181;

import src.com.leetcode.s206.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode result = null;
        ListNode resultPointer = null;
        int currentCount = 0;
        ListNode pointer = head.next;
        while (pointer != null) {
            if (pointer.val == 0) {
                if (result == null) {
                    result = new ListNode(currentCount);
                    resultPointer = result;
                    currentCount = 0;
                } else {
                    resultPointer.next = new ListNode(currentCount);
                    resultPointer = resultPointer.next;
                    currentCount = 0;
                }
            } else {
                currentCount += pointer.val;
            }
            pointer = pointer.next;
        }
        return result;
    }
}