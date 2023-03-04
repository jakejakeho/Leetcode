package src.com.leetcode.s146;
import java.util.HashMap;

public class LRUCache {

    public static class DoubleLinkedListNode {

        DoubleLinkedListNode next;

        DoubleLinkedListNode prev;

        Integer key;

        Integer value;
    }

    DoubleLinkedListNode head = null;

    DoubleLinkedListNode tail = null;

    HashMap<Integer, DoubleLinkedListNode> map = new HashMap<>();

    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        DoubleLinkedListNode node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            DoubleLinkedListNode prev = node.prev;
            DoubleLinkedListNode next = node.next;
            if (prev != null && next != null) {
                prev.next = next;
                next.prev = prev;
            }
            if (tail == node && next != null) {
                tail = next;
            }
            DoubleLinkedListNode currentHead = head;
            head = node;
            head.prev = currentHead;
            head.next = null;
            currentHead.next = node;
            return node.value;
        }
    }

    public void put(int key, int value) {
        boolean isNewNode = !map.containsKey(key);
        int mapSize = map.size();
        if (isNewNode && mapSize == capacity) {
            map.remove(tail.key);
            tail = tail.next;
        }
        if (isNewNode) {
            DoubleLinkedListNode newNode = new DoubleLinkedListNode();
            newNode.key = key;
            newNode.value = value;
            map.put(key, newNode);
            if (head != null) {
                DoubleLinkedListNode currentHead = head;
                newNode.prev = currentHead;
                currentHead.next = newNode;
            }
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
        } else {
            map.get(key).value = value;
            get(key);
        }
    }

    public static void main(String[] args) {
        /**
         * Input
         * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
         * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
         * Output
         * [null, null, null, 1, null, -1, null, -1, 3, 4]
         *
         * Explanation
         * LRUCache lRUCache = new LRUCache(2);
         * lRUCache.put(1, 1); // cache is {1=1}
         * lRUCache.put(2, 2); // cache is {1=1, 2=2}
         * lRUCache.get(1);    // return 1
         * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
         * lRUCache.get(2);    // returns -1 (not found)
         * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
         * lRUCache.get(1);    // return -1 (not found)
         * lRUCache.get(3);    // return 3
         * lRUCache.get(4);    // return 4
         */

        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println("return 1 -> " + lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println("return -1 -> " + lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println("return -1 -> " + lRUCache.get(1));    // return -1 (not found)
        System.out.println("return 3 -> " + lRUCache.get(3));    // return 3
        System.out.println("return 4 -> " + lRUCache.get(4));    // return 4
    }
}