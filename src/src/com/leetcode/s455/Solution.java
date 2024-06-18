package src.com.leetcode.s455;

import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int contentChildren = 0;
        int gPointer = 0;
        int sPointer = 0;
        while (gPointer < g.length && sPointer < s.length) {
            while (sPointer < s.length) {
                if (!(s[sPointer] >= g[gPointer])) {
                    sPointer++;
                } else {
                    contentChildren++;
                    sPointer++;
                    break;
                }
            }
            gPointer++;
        }
        return contentChildren;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
        System.out.println(solution.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
        System.out.println(solution.findContentChildren(new int[]{1, 2, 3}, new int[]{3}));
    }
}