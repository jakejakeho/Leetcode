package src.com.leetcode.s206;
import java.util.List;

public class ListNode {

    public Integer val = null;

    public ListNode next;

    public ListNode() {}

    ListNode(int val) {this.val = val;}

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(List<Integer> list) {
        ListNode pointer = this;
        for (Integer value : list) {
            if (this.val == null) {
                this.val = value;
            } else {
                ListNode newNode = new ListNode(value);
                pointer.next = newNode;
                pointer = newNode;
            }
        }
    }

    public ListNode(Integer val) {
        this.val = val;
    }

    public void print() {
        System.out.println(this);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        ListNode pointer = this;
        stringBuffer.append("[");
        int i = 0;
        while (true) {
            if (pointer.val != null) {stringBuffer.append(pointer.val);}
            if (pointer.next == null) {
                break;
            } else {
                stringBuffer.append(", ");
                pointer = pointer.next;
            }
            if (i++ >= 1000)
                break;
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}