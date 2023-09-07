package src.com.leetcode.s92;

import src.com.leetcode.s206.ListNode;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(solution.reverseBetween(head, 2, 4));
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftMostNode = new ListNode(0);
        leftMostNode.next = head;
        head = leftMostNode;
        System.out.println(head);

        int index = 0;
        ListNode pointer = head;
        ListNode leftLeftNode = null;
        ListNode leftNode = null;
        ListNode lastNode = null;
        while (pointer != null) {
            System.out.println(pointer.val);
            if (leftNode != null) {
                ListNode nextNode = pointer.next; // 4
                pointer.next = lastNode;// 3 -> 2
                lastNode = pointer; // 3
                pointer = nextNode; // 4
            } else {
                lastNode = pointer;
            }


            if (index == left) {
                leftLeftNode = lastNode;
                leftNode = pointer;
            }


            if (index == right) {
//                leftLeftNode.next = pointer;
//                leftLeftNode.next = pointer.next;
                break;
            }
            index++;
        }
        return head.next;
    }
}