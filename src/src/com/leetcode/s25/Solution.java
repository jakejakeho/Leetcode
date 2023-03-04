package src.com.leetcode.s25;

import src.com.leetcode.s206.ListNode;

import java.util.List;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.val = 0;
        dummy.next = head;
        ListNode curr = head;
        ListNode prev = dummy;
        ListNode temp = null;

        int count = k;

        while (curr != null) {
            if (count > 1) {
                temp = prev.next;
                prev.next = curr.next;
                curr.next = curr.next.next;
                prev.next.next = temp;
                count--;
            } else {
                prev = curr;
                curr = curr.next;

                ListNode end = curr;

                for (int i = 0; i < k; ++i) {
                    if (end == null) {
                        return dummy.next;
                    }
                    end = end.next;
                }
                count = k;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode rootNode = new ListNode(List.of(1, 2, 3, 4, 5));
        System.out.print("Input: ");
        rootNode.print();
        int k = 3;
        System.out.printf(" k = %d\n", k);

        ListNode result = new Solution().reverseKGroup(rootNode, k);
        result.print();
    }
}