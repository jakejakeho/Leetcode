package src.com.leetcode.s206;

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
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode lastNode = head;
        ListNode current = head.next;
        lastNode.next = null;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = lastNode;
            lastNode = current;
            current = nextNode;
        }
        return lastNode;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode =  new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        System.out.println(solution.reverseList(listNode));
    }
}