package src.com.leetcode.s24;

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

    void printVal() {
        System.out.println(this.val);
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
        System.out.println(result);
    }
}