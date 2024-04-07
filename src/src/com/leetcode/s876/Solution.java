package src.com.leetcode.s876;

import src.com.leetcode.s206.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head.next;
        while (fastPointer != null) {
            slowPointer = slowPointer.next;
            if (fastPointer.next != null) {
                fastPointer = fastPointer.next.next;
            } else {
                fastPointer = null;
            }
        }
        return slowPointer;
    }
}