package src.com.leetcode.s706;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MyHashMap {

    private static class HashMapNode {

        int key;

        int value;

        public HashMapNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
        myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
        System.out.println("done");
    }

    private final LinkedList<HashMapNode>[] array = new LinkedList[1000];

    public MyHashMap() {
    }

    public void put(int key, int value) {
        int hash = getHash(key);
        if (array[hash] == null) {
            array[hash] = new LinkedList<>();
        }
        for (HashMapNode node : array[hash]) {
            if (node.key == key) {
                node.value = value;
                return;
            }
        }
        array[hash].add(new HashMapNode(key, value));
    }

    public int get(int key) {
        int hash = getHash(key);
        if (array[hash] == null)
            return -1;

        for (HashMapNode node : array[hash]) {
            if (node.key == key) {
                return node.value;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int hash = getHash(key);
        if (array[hash] == null)
            return;

        for (HashMapNode node : array[hash]) {
            if (node.key == key) {
                array[hash].remove(node);
                return;
            }
        }
    }

    public int getHash(int key) {
        return key % 1000;
    }
}
