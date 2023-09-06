package src.com.leetcode.s725;
import java.util.Arrays;

import src.com.leetcode.s206.ListNode;

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

    public static void main(String[] args) {
        Solution solution =new Solution();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        System.out.println(Arrays.toString(solution.splitListToParts(head, 5)));
    }
    public ListNode[] splitListToParts(ListNode head, int k) {
        int listLength = 0;
        ListNode pointer = head;
        while(pointer != null) {
            listLength++;
            pointer = pointer.next;
        }
        int[] lengths = new int[k];
        Arrays.fill(lengths, listLength / k);
        for (int i = 0; i <listLength % k; i++) {
            lengths[i]++;
        }
        ListNode[] result = new ListNode[k];
        pointer = head;
        int resultIndex = 0;
        int currentIndex = 0;
        while (pointer != null) {
            if (result[resultIndex] == null)
                result[resultIndex] = pointer;
            if (currentIndex == lengths[resultIndex] - 1) {
                currentIndex = 0;
                resultIndex++;
                ListNode nextPointer = pointer.next;
                pointer.next = null;
                pointer = nextPointer;
            } else {
                pointer = pointer.next;
                currentIndex++;
            }
        }
        return result;
    }
}