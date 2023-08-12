package src.com.leetcode.s205;

import java.util.HashMap;
import java.util.Objects;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        String newS = assignStr(s);
        String newT = assignStr(t);
        return Objects.equals(newS, newT);
    }

    public String assignStr(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        char used = 'a';
        HashMap<Character, Character> hashMap = new HashMap<>();
        for (char c : chars) {
            hashMap.putIfAbsent(c, used);
            used++;
            sb.append(hashMap.get(c));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isIsomorphic("egg", "add");
    }
}
