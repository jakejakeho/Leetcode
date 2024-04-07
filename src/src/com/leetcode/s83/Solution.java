package src.com.leetcode.s83;

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
    public ListNode deleteDuplicates(ListNode head) {
        boolean[] exist = new boolean[201];
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode lastNode = dummy;
        ListNode current = head;
        while (current != null) {
            if (exist[current.val + 100]) {
                lastNode.next = current.next;
            } else {
                exist[current.val + 100] = true;
                lastNode = current;
            }
            current = current.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);
        System.out.println(solution.deleteDuplicates(l1));
    }
}