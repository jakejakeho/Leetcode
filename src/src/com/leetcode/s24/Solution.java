package src.com.leetcode.s24;

import java.util.List;



public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode firstNode = null;
        ListNode secondNode = null;

        if (head != null) {
            firstNode = head;
            if (head.next != null) {
                secondNode = head.next;
            }
        }

        boolean isFirst = true;
        ListNode newHead = firstNode;
        ListNode lastSecondNode = null;
        while (firstNode != null & secondNode != null) {
            // swap
            ListNode secondNodeNext = secondNode.next;
            ListNode secondNodeNextNext = null;
            if (secondNodeNext != null) {
                secondNodeNextNext = secondNodeNext.next;
            }
            if (isFirst) {
                newHead = secondNode;
                isFirst = false;
            }
            secondNode.next = firstNode;
            firstNode.next = secondNodeNext;
            if (lastSecondNode != null) {
                lastSecondNode.next = secondNode;
            }

            lastSecondNode = firstNode;

            firstNode = secondNodeNext;
            secondNode = secondNodeNextNext;
        }

        return newHead;
    }

    public static void main (String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4);
        ListNode firstNode = null;
        ListNode traversalNode = null;
        for (int i = 0; i < list.size(); i++) {
            if (firstNode == null) {
                firstNode = new ListNode(list.get(i));
                traversalNode = firstNode;
            } else {
                traversalNode.next = new ListNode(list.get(i));
                traversalNode = traversalNode.next;
            }
        }
        System.out.println("input:");
        firstNode.print();

        Solution solution = new Solution();
        ListNode result = solution.swapPairs(firstNode);
        System.out.println("result:");
        result.print();
    }
}
