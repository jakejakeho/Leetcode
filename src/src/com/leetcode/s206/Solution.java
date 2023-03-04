package src.com.leetcode.s206;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode pointer = head;
        ListNode lastNode = null;
        do {
            ListNode nextNode = pointer.next;
            pointer.next = lastNode;
            lastNode = pointer;
            pointer = nextNode;
        } while (pointer != null);
        return lastNode;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode list;
        ListNode output;
        /*
         * Input: head = [1,2,3,4,5]
         * Output: [5,4,3,2,1]
         */
        list = new ListNode(List.of(1, 2, 3, 4, 5));
        System.out.println("Input: ");
        list.print();
        output = solution.reverseList(list);
        System.out.println("Output: ");
        output.print();

        /*
         * Input: head = [1,2]
         * Output: [2,1]
         */
        list = new ListNode(List.of(1, 2));
        System.out.println("Input: ");
        list.print();
        output = solution.reverseList(list);
        System.out.println("Output: ");
        output.print();

        /*
         * Input: head = []
         * Output: []
         */
        list = new ListNode(new ArrayList<>());
        System.out.println("Input: ");
        list.print();
        output = solution.reverseList(list);
        System.out.println("Output: ");
        output.print();
    }
}