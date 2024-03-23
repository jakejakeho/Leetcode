package src.com.leetcode.s143;

import java.util.ArrayList;
import java.util.List;

import src.com.leetcode.s206.ListNode;

public class Solution {

    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slowPointer = dummy;
        ListNode fastPointer = dummy;
        while (fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
            if (fastPointer.next != null)
                fastPointer = fastPointer.next;
        }
        if (slowPointer == fastPointer) {
            return;
        }

        ListNode rightList = fastPointer;

        ListNode lastNode = null;
        ListNode reverseRightPointer = slowPointer.next;
        while (reverseRightPointer != null) {
            ListNode nextNode = reverseRightPointer.next;
            reverseRightPointer.next = lastNode;
            lastNode = reverseRightPointer;
            reverseRightPointer = nextNode;
        }

        ListNode pointer = head;
        ListNode rightPointer = rightList;
        while (rightPointer != null) {
            ListNode nextNode = pointer.next;
            pointer.next = rightPointer;
            ListNode nextRightNode = rightPointer.next;
            rightPointer.next = nextNode;
            rightPointer = nextRightNode;
            pointer = nextNode;
        }
        pointer.next = null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode head;
        /*
         * Input: head = [1,2,3,4]
         * Output: [1,4,2,3]
         */
        head = new ListNode(List.of(1));
        System.out.print("Input: head = ");
        head.print();

        solution.reorderList(head);
        System.out.print("Output = ");
        head.print();

    }
}
