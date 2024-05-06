package src.com.leetcode.s2487;

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
    public ListNode removeNodes(ListNode head) {
        ListNode reversedHead = reverseList(head);
        ListNode lastNode = reversedHead;
        ListNode reversed = reversedHead.next;
        while (reversed != null) {
            if (reversed.val  < lastNode.val) {
                lastNode.next = reversed.next;
            } else {
                lastNode = reversed;
            }
            reversed = reversed.next;
        }
        return reverseList(reversedHead);
    }

    public ListNode reverseList(ListNode head) {
        ListNode lastNode = null;
        ListNode prev = head;
        if (head.next == null) {
            lastNode = head;
        }
        head = head.next;
        prev.next = null;
        while (head != null) {
            ListNode next = head.next;
            if (next == null) {
                lastNode = head;
            }
            head.next = prev;
            prev = head;
            head = next;
        }
        return lastNode;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(8);
        l1.next.next = new ListNode(7);
        l1.next.next.next = new ListNode(6);
        l1.next.next.next.next = new ListNode(10);
        System.out.println(solution.removeNodes(l1));
    }
}