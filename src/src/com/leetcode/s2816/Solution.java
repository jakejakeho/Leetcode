package src.com.leetcode.s2816;

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
    public ListNode doubleIt(ListNode head) {
        ListNode reversed = reverseList(head);
        int carry = 0;
        ListNode pointer = reversed;
        while (pointer != null) {
            int num = pointer.val * 2 + carry;
            carry = num >= 10 ? 1 : 0;
            pointer.val = num % 10;
            if (pointer.next == null && carry == 1){
                pointer.next = new ListNode(1);
                break;
            }
            pointer = pointer.next;
        }
        return reverseList(reversed);
    }

    public ListNode reverseList(ListNode head) {
        ListNode lastNode = head;
        ListNode nextNode = head.next;
        head.next = null;
        while (nextNode != null) {
            ListNode nextNextNode = nextNode.next;
            nextNode.next = lastNode;
            lastNode = nextNode;
            nextNode = nextNextNode;
        }
        return lastNode;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);
        l1.next.next = new ListNode(9);
        System.out.println(solution.doubleIt(l1));
    }
}