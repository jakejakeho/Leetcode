package src.com.leetcode.s25;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    void print() {
        ListNode traversalNode = this;
        String result = "";
        while(traversalNode != null) {
            result += traversalNode.val;
            traversalNode = traversalNode.next;
            if (traversalNode != null) {
                result += ",";
            }
        }
        System.out.printf("[%s]", result);
    }
}