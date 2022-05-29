package src.com.leetcode.s49;

import java.util.Arrays;

public class s49 {
    public static void main(String[] args) {
        Solution49 solution49 = new Solution49();

        String[] strs = { "eat","tea","tan","ate","nat","bat" };

        System.out.println("Input: "+ Arrays.toString(strs) + "\nOutput: " + solution49.groupAnagrams(strs));

    }
}
