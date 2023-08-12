package src.com.leetcode.s191;
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 0;
        n = 11;
        System.out.println(solution.hammingWeight(n));
    }
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
