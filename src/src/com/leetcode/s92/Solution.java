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
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        head = dummyNode;

        ListNode pointer = head;
        ListNode lastNode = null;
        ListNode leftLeftNode = null;
        ListNode leftNode = null;
        int currentIndex = 0;
        while (pointer != null) {
            ListNode nextNode = pointer.next;

            if (currentIndex == right) {
                if (leftLeftNode != null) {
                    leftLeftNode.next = pointer;
                    leftNode.next = pointer.next;
                    pointer.next = lastNode;
                }
                break;
            }

            if (leftNode != null) {
                pointer.next = lastNode;
            }

            if (currentIndex == left) {
                leftLeftNode = lastNode;
                leftNode = pointer;
            }

            lastNode = pointer;
            pointer = nextNode;
            currentIndex++;
        }
        return head.next;
    }
}