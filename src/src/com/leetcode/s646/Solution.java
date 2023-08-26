package src.com.leetcode.s646;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}}));
    }

    public int findLongestChain(int[][] pairs) {
        List<int[]> list = new ArrayList<>();
        Collections.addAll(list, pairs);
        list.sort(Comparator.comparingInt(a -> a[1]));
        int longest = 1;
        int lastB = list.get(0)[1];
        for (int i = 1; i < list.size(); i++) {
            int c = list.get(i)[0];
            if (lastB < c) {
                lastB = list.get(i)[1];
                longest++;
            }
        }
        return longest;
    }
}