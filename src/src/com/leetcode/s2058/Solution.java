package src.com.leetcode.s2058;

import src.com.leetcode.s206.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> nodes = new ArrayList<>();
        ListNode pointer = head;
        if (head.next == null)
            return null;
        int index = 0;
        ListNode lastNode = head;
        pointer = pointer.next;
        while (pointer.next != null) {
            if (lastNode.val < pointer.val && pointer.next.val < pointer.val) {
                nodes.add(index);
            } else if (lastNode.val > pointer.val && pointer.next.val > pointer.val) {
                nodes.add(index);
            }
            index++;
            lastNode = pointer;
            pointer = pointer.next;
        }

        int[] result = new int[2];
        int min = -1;
        int max = -1;
        nodes.sort(Comparator.naturalOrder());
        if (nodes.size() >= 2) {
            max = Math.abs(nodes.get(nodes.size() - 1) - nodes.get(0));
        }
        for (int i = 0; i < nodes.size() - 1; i++) {
            int distance = nodes.get(i + 1) - nodes.get(i);
            if (min == -1) {
                min = distance;
            } else {
                min = Math.min(min, distance);
            }
        }
        result[0] = min;
        result[1] = max;
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node = new ListNode(5);
        node.next = new ListNode(3);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(1);
        node.next.next.next.next.next.next = new ListNode(2);
        System.out.println(Arrays.toString(solution.nodesBetweenCriticalPoints(node)));

        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(3);
        node1.next.next = new ListNode(2);
        node1.next.next.next = new ListNode(2);
        node1.next.next.next.next = new ListNode(3);
        node1.next.next.next.next.next = new ListNode(2);
        node1.next.next.next.next.next.next = new ListNode(2);
        node1.next.next.next.next.next.next.next = new ListNode(2);
        node1.next.next.next.next.next.next.next.next = new ListNode(7);
        System.out.println(Arrays.toString(solution.nodesBetweenCriticalPoints(node1)));
    }
}