package src.com.leetcode.s76;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "ADOBECODEBANC";
        String t = "ABC";

//        System.out.println("Input: s = \"" + s + "\", t = \"" + t + "\"");
//        System.out.println("Output: (Excepted: \"BANC\")\"" + solution.minWindow(s, t) + "\"");
//
//        s = "a";
//        t = "a";
//        System.out.println("\nInput: s = \"" + s + "\", t = \"" + t + "\"");
//        System.out.println("Output: (Excepted: \"a\")\"" + solution.minWindow(s, t) + "\"");
//
//        s = "a";
//        t = "aa";
//        System.out.println("\nInput: s = \"" + s + "\", t = \"" + t + "\"");
//        System.out.println("Output: (Excepted: \"\")\"" + solution.minWindow(s, t) + "\"");
//
//        s = "abc";
//        t = "ac";
//        System.out.println("\nInput: s = \"" + s + "\", t = \"" + t + "\"");
//        System.out.println("Output: (Excepted: \"abc\")\"" + solution.minWindow(s, t) + "\"");

        s = "aaaaaaaaaaaabbbbbcdd";
        t = "abcdd";
        System.out.println("\nInput: s = \"" + s + "\", t = \"" + t + "\"");
        System.out.println("Output: (Excepted: \"abbbbbcdd\")\"" + solution.minWindow(s, t) + "\"");
    }
}
