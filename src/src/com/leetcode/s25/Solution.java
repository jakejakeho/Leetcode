package src.com.leetcode.s25;

import java.util.List;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        return new ListNode();
    }

    public static void main (String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        ListNode rootNode = null;
        ListNode traversalNode = null;
        for (Integer value : list) {
            ListNode newNode = new ListNode(value);
            if (rootNode == null) {
                rootNode = newNode;
                traversalNode = rootNode;
            } else {
                traversalNode.next = newNode;
                traversalNode = newNode;
            }
        }

        System.out.print("Input: ");
        rootNode.print();
        int k = 2;
        System.out.printf(" k = %d\n", k);

        ListNode result = new Solution().reverseKGroup(rootNode, k);
        result.print();
    }
}