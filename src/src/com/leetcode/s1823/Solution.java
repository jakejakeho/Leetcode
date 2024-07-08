package src.com.leetcode.s1823;

import src.com.leetcode.s206.ListNode;

class Solution {
    public int findTheWinner(int n, int k) {
        ListNode rootNode = new ListNode(1);
        rootNode.next = rootNode;
        ListNode lastNode;
        ListNode pointer = rootNode;
        for (int i = 2; i <= n; i++) {
            if (i == n) {
                pointer.next = new ListNode(i);
                pointer.next.next = rootNode;
            } else {
                pointer.next = new ListNode(i);
            }
            pointer = pointer.next;
        }
        lastNode = pointer;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < k; j++) {
                if (j > 0)
                    lastNode = lastNode.next;
                pointer = pointer.next;
            }
            lastNode.next = pointer.next;
        }
        return pointer.next.val;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTheWinner(5, 2));
        System.out.println(solution.findTheWinner(6, 5));
        System.out.println(solution.findTheWinner(3, 1));
    }
}