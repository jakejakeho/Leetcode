package src.com.leetcode.s445;

import src.com.leetcode.s206.ListNode;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(l1, l2);
        System.out.println(result.val);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Pointer = l1;
        ListNode l2Pointer = l2;

        Stack<ListNode> l1Stack = new Stack<>();
        Stack<ListNode> l2Stack = new Stack<>();

        while (l1Pointer != null) {
            l1Stack.push(l1Pointer);
            l1Pointer = l1Pointer.next;
        }

        while (l2Pointer != null) {
            l2Stack.push(l2Pointer);
            l2Pointer = l2Pointer.next;
        }

        int carry = 0;
        Stack<ListNode> resultStack = new Stack<>();
        while (!l1Stack.isEmpty() || !l2Stack.isEmpty()) {
            int sum = 0;
            if (!l1Stack.isEmpty()) {
                sum += l1Stack.pop().val;
            }

            if (!l2Stack.isEmpty()) {
                sum += l2Stack.pop().val;
            }
            sum += carry;
            carry = sum >= 10 ? 1 : 0;

            resultStack.push(new ListNode(sum % 10));
        }
        if (carry == 1) {
            resultStack.push(new ListNode(1));
        }

        ListNode result = resultStack.pop();
        ListNode resultPointer = result;
        while(!resultStack.isEmpty()) {
            resultPointer.next = resultStack.pop();
            resultPointer = resultPointer.next;
        }
        return result;
    }
}
