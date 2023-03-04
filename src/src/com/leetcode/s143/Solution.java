package src.com.leetcode.s143;
import java.util.ArrayList;
import java.util.List;

import src.com.leetcode.s206.ListNode;

public class Solution {

    public void reorderList(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode pointer = head;
        while (pointer != null) {
            nodes.add(pointer);
            pointer = pointer.next;
        }
        int n = nodes.size();
        pointer = head;
        for (int i = 0; i < ((n + 1) / 2); i++) {
            if (i > 0) {
                pointer.next = nodes.get(i);

                pointer = pointer.next;
            }
            pointer.next = nodes.get(n - (i + 1));
            pointer = pointer.next;
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
        head = new ListNode(List.of(1, 2, 3, 4));
        System.out.print("Input: head = ");
        head.print();

        solution.reorderList(head);
        System.out.print("Output = ");
        head.print();
    }
}
