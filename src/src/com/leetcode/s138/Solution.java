package src.com.leetcode.s138;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Node head = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);
        node4.next = null;
        node4.random = head;
        node3.next = node4;
        node3.random = node2;
        node2.next = node3;
        node2.random = node4;
        node1.next = node2;
        node1.random = head;
        head.next = node1;
        head.random = null;
        Node copiedHead = solution.copyRandomList(head);
        Node printPoniter = copiedHead;
        while (printPoniter != null) {
            System.out.println(
                "val = " + printPoniter.val + " next = " + (printPoniter.next != null ? printPoniter.next.val : null)
                    + "random = " + (printPoniter.random != null ? printPoniter.random.val : null));
            printPoniter = printPoniter.next;
        }
    }

    public Node copyRandomList(Node head) {
        List<Node> copiedList = new ArrayList<>();
        HashMap<Node, Integer> oldNodeCache = new HashMap<>();
        Node pointer = head;
        int index = 0;
        while (pointer != null) {
            copiedList.add(new Node(pointer.val));
            oldNodeCache.put(pointer, index);
            index++;
            pointer = pointer.next;
        }

        pointer = head;
        index = 0;
        while (pointer != null) {
            if (pointer.random != null) {
                copiedList.get(index).random = copiedList.get(oldNodeCache.get(pointer.random));
            } else {
                copiedList.get(index).random = null;
            }
            if (oldNodeCache.get(pointer.next) != null) {
                copiedList.get(index).next = copiedList.get(oldNodeCache.get(pointer.next));
            } else {
                copiedList.get(index).next = null;
            }
            pointer = pointer.next;
            index++;
        }
        return !copiedList.isEmpty() ? copiedList.get(0) : null;
    }
}