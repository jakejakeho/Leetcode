package src.com.leetcode.s23;

import src.com.leetcode.s206.ListNode;

import java.util.List;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;
        int interval = 1;

        while (interval < size) {
            for (int i = 0; i < (size - interval); i += 2 * interval) {
                lists[i] = mergeLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return size > 0 ? lists[0] : null;
    }

    public ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        dummy.val = 0;
        ListNode current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        /**
         * Input: lists = [[1,4,5],[1,3,4],[2,6]]
         * Output: [1,1,2,3,4,4,5,6]
         * Explanation: The linked-lists are:
         * [
         *   1->4->5,
         *   1->3->4,
         *   2->6
         * ]
         * merging them into one sorted list:
         * 1->1->2->3->4->4->5->6
         */
        List<List<Integer>> input = List.of(List.of(1, 4, 5), List.of(1, 3, 4), List.of(2, 6));
        List<ListNode> list = input.stream().map(ListNode::new).toList();
        ListNode[] array = list.toArray(new ListNode[0]);
        Solution solution = new Solution();
        ListNode result = solution.mergeKLists(array);
        result.print();
    }
}