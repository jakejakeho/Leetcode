package src.com.leetcode.s2;

import src.com.leetcode.s206.ListNode;

import java.util.List;
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Pointer = l1;
        ListNode l2Pointer = l2;

        boolean needPlusOne = false;
        ListNode result = null;
        ListNode lastNode = null;
        while (l1Pointer != null || l2Pointer != null) {
            Integer l1Val = 0;
            if (l1Pointer != null) {
                l1Val= l1Pointer.val;
                l1Pointer = l1Pointer.next;
            }

            Integer l2Val = 0;
            if (l2Pointer != null) {
                l2Val = l2Pointer.val;
                l2Pointer = l2Pointer.next;
            }

            Integer digitResult = 0;
            if (needPlusOne)
                digitResult += 1;
            digitResult += l1Val;
            digitResult += l2Val;
            if (digitResult >= 10) {
                needPlusOne = true;
                digitResult %= 10;
            } else {
                needPlusOne = false;
            }

            ListNode newNode = new ListNode(digitResult);
            if (lastNode == null) {
                lastNode = newNode;
            } else {
                lastNode.next = newNode;
                lastNode = lastNode.next;
            }
            if (result == null) {
                result = newNode;
            }
        }
        if (needPlusOne) {
            ListNode newNode = new ListNode(1);
            if (lastNode != null) {
                lastNode.next = newNode;
            } else {
                result = newNode;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = null, l2 = null, result = null;


        /*
         * Input: l1 = [2,4,3], l2 = [5,6,4]
         * Output: [7,0,8]
         * Explanation: 342 + 465 = 807.
         */
        l1 = new ListNode(List.of(2, 4, 3));
        l2 = new ListNode(List.of(5, 6, 4));
        result = solution.addTwoNumbers(l1, l2);
        result.print();

    }
}
