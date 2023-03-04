package src.com.leetcode.s146;

import org.w3c.dom.Node;

import java.util.HashMap;

public class LRUCache {

    public static class DoubleLinkedListNode {

        DoubleLinkedListNode next = null;

        DoubleLinkedListNode prev = null;

        Integer key;

        Integer value;
    }

    DoubleLinkedListNode head;

     DoubleLinkedListNode tail = null;

    HashMap<Integer, DoubleLinkedListNode> map;

    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new DoubleLinkedListNode();
        tail = new DoubleLinkedListNode();
        head.key = 0;
        head.value = 0;
        tail.key = 0;
        tail.value = 0;
        head.prev = tail;
        tail.next = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        DoubleLinkedListNode node = map.get(key);
        delete(node);
        insert(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key))
            delete(map.get(key));
        DoubleLinkedListNode newNode = new DoubleLinkedListNode();
        newNode.key = key;
        newNode.value = value;
        map.put(key, newNode);
        insert(newNode);

        if (map.size() > capacity) {
            DoubleLinkedListNode lru = tail.next;
            delete(lru);
            map.remove(lru.key);
        }
    }

    private void delete(DoubleLinkedListNode node) {
        DoubleLinkedListNode prev = node.prev;
        DoubleLinkedListNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void insert(DoubleLinkedListNode node) {
        DoubleLinkedListNode prev = head.prev;
        DoubleLinkedListNode next = head;

        prev.next = node;
        next.prev = node;

        node.next = next;
        node.prev = prev;
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