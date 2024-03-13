package src.com.leetcode.s1171;

import src.com.leetcode.s206.ListNode;

import java.util.HashMap;
import java.util.Map;

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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int prefixSum = 0;
        Map<Integer, ListNode> prefixSumMap = new HashMap<>();
        ListNode pointer = dummy;
        while (pointer != null) {
            prefixSum += pointer.val;
            if (prefixSumMap.containsKey(prefixSum)) {
                ListNode prev = prefixSumMap.get(prefixSum);
                ListNode toRemove = prev.next;
                int p = prefixSum + (toRemove != null ? toRemove.val : 0);

                while (p != prefixSum) {
                    prefixSumMap.remove(p);
                    toRemove = toRemove.next;
                    p += (toRemove != null ? toRemove.val : 0);
                }
                prev.next = pointer.next;
            } else {
                prefixSumMap.put(prefixSum, pointer);
            }
            pointer = pointer.next;

        }
        return dummy.next;
    }
}