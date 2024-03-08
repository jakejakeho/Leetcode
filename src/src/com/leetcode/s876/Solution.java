package src.com.leetcode.s876;

import src.com.leetcode.s206.ListNode;

class Solution {
    public ListNode middleNode(ListNode head) {
        int length = 0;
        ListNode pointer = head;
        while (pointer != null) {
            pointer = pointer.next;
            length++;
        }

        pointer = head;
        for (int i = 0; i < length / 2; i++) {
            pointer = pointer.next;
        }
        return pointer;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Solution solution = new Solution();
        System.out.println(solution.middleNode(head));
    }
}