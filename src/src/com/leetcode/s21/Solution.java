package src.com.leetcode.s21;
import java.util.List;

import src.com.leetcode.s206.ListNode;

public class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode resultHead = null;
        ListNode result = null;
        ListNode pointer1 = list1;
        ListNode pointer2 = list2;
        while (pointer1 != null || pointer2 != null) {
            int val1 = pointer1 != null ? pointer1.val : Integer.MAX_VALUE;
            int val2 = pointer2 != null ? pointer2.val : Integer.MAX_VALUE;
            ListNode smallerNode = val1 < val2 ? pointer1 : pointer2;
            ListNode newNode = new ListNode(smallerNode.val);
            if (result == null) {
                result = newNode;
                resultHead = result;
            } else {
                result.next = newNode;
                result = result.next;
            }
            if (val1 < val2) {
                pointer1 = pointer1.next;
            } else {
                pointer2 = pointer2.next;
            }
        }
        return resultHead;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode list1 = null, list2 = null, output = null;
        /*
         * Input: list1 = [1,2,4], list2 = [1,3,4]
         * Output: [1,1,2,3,4,4]
         */
        list1 = new ListNode(List.of(1, 2, 4));
        System.out.println("List 1");
        list1.print();
        list2 = new ListNode(List.of(1, 3, 4));
        System.out.println("List 2");
        list2.print();
        output = solution.mergeTwoLists(list1, list2);
        System.out.println("Output");
        output.print();
    }
}
