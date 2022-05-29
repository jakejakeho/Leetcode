package src.com.leetcode.s242;

public class Main242 {

    public static void main(String[] args) {
        Solution242 solution242 = new Solution242();

        String s = "anagram";
        String t = "nagaram";

        System.out.println("Input: s = \"" + s + "\", t = \"" + t + "\"\nOutput: " + solution242.isAnagram(s, t));
    }
}
