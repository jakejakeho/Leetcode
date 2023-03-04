package src.com.leetcode.s143;

import java.util.ArrayList;
import java.util.List;

import src.com.leetcode.s206.ListNode;

public class Solution {

    public void reorderList(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head.next;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        // reverse right list

        ListNode pointer = slowPointer.next;
        ListNode prev = slowPointer.next = null;
        while(pointer != null) {
            ListNode nextNode = pointer.next;
            pointer.next = prev;
            prev = pointer;
            pointer = nextNode;
        }

        ListNode leftPointer = head;
        ListNode rightPointer = fastPointer;
        while(leftPointer != null && rightPointer != null) {
            ListNode leftNext = leftPointer.next;
            ListNode rightNext = rightPointer.next;
            leftPointer.next = rightPointer;
            rightPointer.next = leftNext;
            leftPointer = leftNext;
            rightPointer = rightNext;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode head;
        /*
         * Input: head = [1,2,3,4]
         * Output: [1,4,2,3]
         */
        head = new ListNode(List.of(1, 2, 3, 4, 5, 6));
        System.out.print("Input: head = ");
        head.print();

        solution.reorderList(head);
        System.out.print("Output = ");
        head.print();
    }
}
