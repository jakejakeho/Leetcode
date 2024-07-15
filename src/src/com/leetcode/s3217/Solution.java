package src.com.leetcode.s3217;

import src.com.leetcode.s206.ListNode;

import java.util.HashSet;
import java.util.Set;

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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode lastNode = dummy;
        ListNode pointer = head;
        while (pointer != null) {
            if (set.contains(pointer.val)) {
                lastNode.next = pointer.next;
            } else {
                lastNode = lastNode.next;
            }
            pointer = pointer.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        System.out.println(solution.modifiedList(new int[]{1, 2, 3}, l1));

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(1);
        l2.next.next.next = new ListNode(2);
        l2.next.next.next.next = new ListNode(1);
        l2.next.next.next.next.next = new ListNode(2);
        System.out.println(solution.modifiedList(new int[]{1}, l2));

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(2);
        l3.next.next = new ListNode(3);
        l3.next.next.next = new ListNode(4);
        System.out.println(solution.modifiedList(new int[]{5}, l3));
    }
}