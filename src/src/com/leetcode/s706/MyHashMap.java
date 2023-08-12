package src.com.leetcode.s706;

public class MyHashMap {

    private final Integer[] array = new Integer[(int) Math.pow(10, 6) + 1];

    public MyHashMap() {
    }

    public void put(int key, int value) {
        array[key] = value;
    }

    public int get(int key) {
        return array[key] == null ? -1 : array[key];
    }

    public void remove(int key) {
        array[key] = null;
    }
}
