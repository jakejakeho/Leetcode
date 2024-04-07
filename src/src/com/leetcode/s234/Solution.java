package src.com.leetcode.s234;

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
    public boolean isPalindrome(ListNode head) {
        ListNode lastNode = null;
        ListNode slowPointer = head;
        ListNode fastPointer = slowPointer.next;
        ListNode firstHalf = null;
        ListNode secondHalf = null;
        int numOfElements = 1;
        while (fastPointer != null) {
            ListNode nextNode = slowPointer.next;
            slowPointer.next = lastNode;
            lastNode = slowPointer;
            firstHalf = lastNode;
            secondHalf = nextNode;
            slowPointer = nextNode;
            fastPointer = fastPointer.next;
            numOfElements++;
            if (fastPointer != null) {
                fastPointer = fastPointer.next;
                numOfElements++;
            }
        }
        if (numOfElements == 1) {
            return true;
        }
        if (numOfElements % 2 == 1) {
            secondHalf = secondHalf.next;
        }
        ListNode p1 = firstHalf;
        ListNode p2 = secondHalf;
        while (p1 != null && p2 != null) {
            if (p1.val != p2.val)
                return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(1);
        System.out.println(solution.isPalindrome(l1));
    }
}