package src.com.leetcode.s146;

import java.util.HashMap;

public class LRUCache {

    class DoublyLinkedListNode {

        DoublyLinkedListNode next;

        DoublyLinkedListNode prev;

        int key;

        int val;
    }

    private int size;

    private DoublyLinkedListNode head;

    private DoublyLinkedListNode tail;

    private HashMap<Integer, DoublyLinkedListNode> hashMap = new HashMap<>();

    private int currentSize = 0;

    LRUCache(int size) {
        this.size = size;
    }

    public void put(int key, int value) {
        if (!hashMap.containsKey(key)) {
            DoublyLinkedListNode newNode = new DoublyLinkedListNode();
            hashMap.put(key, newNode);
            newNode.key = key;
            newNode.val = value;
            if (head == null) {
                head = newNode;
                tail = newNode;
                currentSize = 1;
                return;
            }

            if (currentSize + 1 > size) {
                evict();
            }

            currentSize++;
            if (tail != null) {
                tail.next = newNode;
                newNode.prev = tail;
            } else {
                head = newNode;
            }
            tail = newNode;
        } else {
            get(key);
            hashMap.get(key).val = value;
        }
    }

    public int get(int key) {
        DoublyLinkedListNode node = hashMap.get(key);
        if (node == null) {return -1;}
        if (node == tail) {return node.val;}
        if (node == head) {
            head = head.next;
            head.prev = null;
        } else if (node != tail) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        tail.next = node;
        node.prev = tail;
        tail = node;
        return node.val;
    }

    public void evict() {
        hashMap.remove(head.key);
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        currentSize -= 1;
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

        int testCase = 2;
        if (testCase == 0) {
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
        } else if (testCase == 1) {
            LRUCache lRUCache = new LRUCache(1);
            lRUCache.put(2, 1); // cache is {2=1}
            System.out.println("return 1 -> " + lRUCache.get(2));    // return 1
            lRUCache.put(3, 2); // cache is {3=2}
            System.out.println("return -1 -> " + lRUCache.get(2));    // return -1
            System.out.println("return 2 -> " + lRUCache.get(3));    // return 2
        } else if (testCase == 2) {
            LRUCache lRUCache = new LRUCache(2);
            lRUCache.put(2, 1); // cache is {2=1}
            lRUCache.put(1, 1); // cache is {2=1, 1=1}
            lRUCache.put(2, 3); // cache is {1=1, 2=3}
            lRUCache.put(4, 1); // cache is {2=3, 4=1}
            System.out.println("return -1 -> " + lRUCache.get(1));    // return -1
            System.out.println("return 3 -> " + lRUCache.get(2));    // return 3
        }
    }
}