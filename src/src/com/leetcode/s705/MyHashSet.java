package src.com.leetcode.s705;

public class MyHashSet {
    public boolean[] array = new boolean[(int)Math.pow(10, 6) + 1];

    public MyHashSet() {

    }

    public void add(int key) {
        array[key] = true;
    }

    public void remove(int key) {
        array[key] = false;
    }

    public boolean contains(int key) {
        return array[key];
    }
}
