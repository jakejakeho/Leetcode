package src.com.leetcode.s1669;

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

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(10);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(13);
        l1.next.next.next = new ListNode(6);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1000000);
        l2.next = new ListNode(1000001);
        l2.next.next = new ListNode(1000002);
        System.out.println(solution.mergeInBetween(l1, 3, 4, l2));
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummyL1 = new ListNode(0);
        dummyL1.next = list1;
        ListNode nodeBeforeA = dummyL1;
        ListNode l1 = dummyL1;
        int current = -1;
        boolean nodeBeforeAFound = false;
        ListNode nodeAfterB = null;
        while (l1 != null) {
            if (current == a - 1) {
                nodeBeforeAFound = true;
            }
            if (!nodeBeforeAFound)
                nodeBeforeA = nodeBeforeA.next;
            if (current == b + 1) {
                nodeAfterB = l1;
            }
            l1 = l1.next;
            current++;
        }
        nodeBeforeA.next = list2;
        ListNode l2 = list2;
        while (l2 != null) {
            if (l2.next == null) {
                l2.next = nodeAfterB;
                break;
            }
            l2 = l2.next;
        }
        return dummyL1.next;
    }
}