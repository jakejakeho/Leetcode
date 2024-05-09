package src.com.leetcode.s2405;
class Solution {
    public int partitionString(String s) {
        int flag = 0;
        int partition = 1;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if ((flag >> c & 1) == 1) {
                flag = 0;
                flag |= 1 << c;
                partition++;
            } else {
                flag |= 1 << c;
            }
        }
        return partition;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.partitionString("abacaba"));
        System.out.println(solution.partitionString("ssssss"));
    }
}