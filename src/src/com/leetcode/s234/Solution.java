package src.com.leetcode.s234;

import src.com.leetcode.s206.ListNode;

import java.util.Objects;

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

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next.next.next = new ListNode(1);
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(1);
        System.out.println(solution.isPalindrome(head));
    }
    public boolean isPalindrome(ListNode head) {
        int size = size(head);
        ListNode beforeHalf = null;
        ListNode afterHalf = head;
        for (int i = 0; i < size / 2; i++) {
            beforeHalf = afterHalf;
            afterHalf = afterHalf.next;
        }
        // is odd
        if (size % 2 == 1) {
            afterHalf = afterHalf.next;
        }

        ListNode lastNode = null;
        ListNode current = head;
        while (current != afterHalf) {
            ListNode nextNode = current.next;
            current.next = lastNode;
            lastNode = current;
            current = nextNode;
        }


        while (beforeHalf != null && afterHalf != null) {
            if (!Objects.equals(beforeHalf.val, afterHalf.val)) {
                return false;
            }
            beforeHalf = beforeHalf.next;
            afterHalf = afterHalf.next;
        }
        return true;
    }

    public int size(ListNode head) {
        int size = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            size++;
        }
        return size;
    }
}