package src.com.leetcode.s138;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node newHead = null;
        Node pointer = head;
        while (pointer != null) {
            Node newNode = new Node(pointer.val);
            if (newHead == null)
                newHead = newNode;
            map.put(pointer, newNode);
            pointer = pointer.next;
        }

        pointer = head;
        while(pointer != null) {
            Node newNode = map.get(pointer);
            newNode.next = map.get(pointer.next);
            newNode.random = map.get(pointer.random);
            pointer = pointer.next;
        }

        return newHead;
    }
}
